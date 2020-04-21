package com.example.weatherking.comment.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.comment.data.Comment;
import com.example.weatherking.comment.repository.CommentMapper;
import com.example.weatherking.util.DateUtil;
import com.example.weatherking.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CommentService extends BaseBean {

    @Autowired
    private CommentMapper commentMapper;

    public Comment createComment(String message) {
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setCreateAt(DateUtil.getCurrentDate());
        commentMapper.insComment(comment);
        return comment;
    }

    public Comment getComment(long commentId) {
        return commentMapper.getComment(commentId);
    }

    public List<Comment> getCommentList() {
        return commentMapper.getCommentListNotDeleted();
    }

    public Comment getCommentForUpdate(long commentId) {
        return commentMapper.getCommentForUpdate(commentId);
    }

    public Comment getCommentLastOne() {
        return commentMapper.getCommentLastOne();
    }

    public void updComment(long commentId, String message) {
        var comment = commentMapper.getCommentForUpdate(commentId);
        comment.setMessage(message);
        updComment(comment);
    }

    public void updComment(Comment comment) {
        comment.setIsUpdated(true);
        comment.setUpdateAt(DateUtil.getCurrentDate());
        commentMapper.updComment(comment);
    }

    public void delComment(long commentId) {
        var comment = getCommentForUpdate(commentId);
        comment.setIsDeleted(true);
        comment.setDeleteAt(DateUtil.getCurrentDate());
        commentMapper.updComment(comment);
    }

    public Comment deserializeComment(JsonNode jsonNode) {
        Comment data = new Comment();
        data.setCommentId(JsonUtil.getJsonLong(jsonNode, "commentId"));
        data.setMessage(JsonUtil.getJsonString(jsonNode, "message"));
        data.setCreateAt(JsonUtil.getJsonDate(jsonNode, "createAt"));
        data.setIsUpdated(JsonUtil.getJsonBoolean(jsonNode, "isUpdated"));
        data.setUpdateAt(JsonUtil.getJsonDate(jsonNode, "updateAt"));
        data.setIsDeleted(JsonUtil.getJsonBoolean(jsonNode, "isDeleted"));
        data.setDeleteAt(JsonUtil.getJsonDate(jsonNode, "deleteAt"));
        return data;
    }

    public Comment deserializeComment(String json) {
        Comment data = null;
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            data = deserializeComment(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Comment> deserializeCommentList(JsonNode jsonNode) {
        List<Comment> list = new ArrayList<>();
        Iterator<JsonNode> jsonNodeIterator = jsonNode.elements();
        while (jsonNodeIterator.hasNext()) {
            JsonNode jsonNodePerItem = jsonNodeIterator.next();
            var item = deserializeComment(jsonNodePerItem);
            if (item != null) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Comment> deserializeCommentList(String json) {
        List<Comment> list = null;
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            list = deserializeCommentList(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }
}
