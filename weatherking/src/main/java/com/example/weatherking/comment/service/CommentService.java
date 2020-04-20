package com.example.weatherking.comment.service;

import com.example.weatherking.BaseBean;
import com.example.weatherking.comment.data.Comment;
import com.example.weatherking.comment.repository.CommentMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseBean {

    @Autowired
    private CommentMapper commentMapper;

    public Comment createComment(String message) {
        Comment comment = new Comment();
        comment.setMessage(message);
        commentMapper.insComment(comment);
        return comment;
    }

    public Comment getComment(long commentId) {
        return commentMapper.getComment(commentId);
    }

    public List<Comment> getCommentList() {
        return commentMapper.getCommentList();
    }

    public Comment getCommentForUpdate(long commentId) {
        return commentMapper.getCommentForUpdate(commentId);
    }

    public Comment getCommentLastOne() {
        return commentMapper.getCommentLastOne();
    }

    public void updComment(Comment comment) {
        commentMapper.updComment(comment);
    }

    public void delComment(long commentId) {
        commentMapper.delComment(commentId);
    }

    public Comment deserializeComment(String json) {
        Comment data = new Comment();
        try {
            var om = new ObjectMapper();
            JsonNode jsonNode = om.readTree(json);
            if (jsonNode.has("commentId")) {
                data.setCommentId(jsonNode.get("commentId").asLong());
            }
            if (jsonNode.has("message")) {
                data.setMessage(jsonNode.get("message").toString());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }
}
