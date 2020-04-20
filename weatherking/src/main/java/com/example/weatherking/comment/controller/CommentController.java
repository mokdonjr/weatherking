package com.example.weatherking.comment.controller;

import com.example.weatherking.BaseBean;
import com.example.weatherking.comment.service.CommentService;
import com.example.weatherking.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

/**
 * 댓글 요청 수신
 */
@RequestMapping("/comments")
@RestController
public class CommentController extends BaseBean {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public String createComment(@RequestParam("message") String message) {
        commentService.createComment(message);
        // TODO : 뭘 응답? RESULT 형식이 있어야할듯
        return "success";
    }

    @GetMapping("/")
    public String getCommentList() throws JSONException {
        // TODO : 페이징
        var list = commentService.getCommentList();
        if (list == null)
            return "no element";
        // TODO : RESULT 형식이 있어야할듯
        return JsonUtil.prettyIndentJson(list);
    }

    @GetMapping("/{commentId}")
    public String getComment(@PathVariable(value = "commentId") long commentId) throws JSONException {
        var comment = commentService.getComment(commentId);
        // TODO : RESULT 형식이 있어야할듯
        return JsonUtil.prettyIndentJson(comment);
    }

    @PutMapping("/{commentId}")
    public String updComment(@PathVariable(value = "commentId") long commentId, @RequestParam("message") String message) {
        var comment = commentService.getCommentForUpdate(commentId);
        if (comment == null) {
            // TODO : 뭘 응답? RESULT 형식이 있어야할듯
            return "no element";
        }
        comment.setMessage(message);
        commentService.updComment(comment);
        // TODO : 뭘 응답? RESULT 형식이 있어야할듯
        return "success";
    }

    @DeleteMapping("/{commentId}")
    public String delComment(@PathVariable(value = "commentId") long commentId) {
        var comment = commentService.getCommentForUpdate(commentId);
        if (comment == null) {
            // TODO : 뭘 응답? RESULT 형식이 있어야할듯
            return "no element";
        }
        commentService.delComment(commentId);
        // TODO : 뭘 응답? RESULT 형식이 있어야할듯
        return "success";
    }
}
