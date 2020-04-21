package com.example.weatherking.comment.controller;

import com.example.weatherking.BaseBean;
import com.example.weatherking.comment.data.Comment;
import com.example.weatherking.comment.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 댓글 요청 수신
 */
@RequestMapping("/comments")
@RestController
@Api(tags = "댓글")
public class CommentController extends BaseBean {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    @ApiOperation(value = "댓글 작성")
    public ResponseEntity<Comment> createComment(@RequestParam("message") String message) {
        var comment = commentService.createComment(message);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/")
    @ApiOperation(value = "댓글 리스트 조회")
    public ResponseEntity<List<Comment>> getCommentList() throws JSONException {
        // TODO : 페이징
        var list = commentService.getCommentList();
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    @ApiOperation(value = "특정 댓글 조회")
    public ResponseEntity<Comment> getComment(@PathVariable(value = "commentId") long commentId) throws JSONException {
        var comment = commentService.getComment(commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    @ApiOperation(value = "댓글 수정")
    public ResponseEntity<Comment> updComment(@PathVariable(value = "commentId") long commentId, @RequestParam("message") String message) {
        var comment = commentService.getCommentForUpdate(commentId);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setMessage(message);
        commentService.updComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{commentId}")
    @ApiOperation(value = "댓글 삭제")
    public ResponseEntity<?> delComment(@PathVariable(value = "commentId") long commentId) {
        var comment = commentService.getCommentForUpdate(commentId);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.delComment(commentId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
