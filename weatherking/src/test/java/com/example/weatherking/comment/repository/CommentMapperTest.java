package com.example.weatherking.comment.repository;

import com.example.weatherking.BaseBeanTest;
import com.example.weatherking.comment.data.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentMapperTest extends BaseBeanTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void testComment() {

        String testMessage = "TEST_MESSAGE_!@#";
        Comment comment = new Comment();
        comment.setMessage(testMessage);

        // create
        commentMapper.insComment(comment);
        long commentId = comment.getCommentId();

        // select for update
        Comment commentSelectedForUpdate = commentMapper.getCommentForUpdate(commentId);
        Assertions.assertEquals(testMessage, commentSelectedForUpdate.getMessage());

        // update
        String updatedMessage = "MMM";
        commentSelectedForUpdate = commentMapper.getCommentForUpdate(commentId);
        commentSelectedForUpdate.setMessage(updatedMessage);
        commentMapper.updComment(commentSelectedForUpdate);

        // select
        Comment commentSelected = commentMapper.getComment(commentId);
        Assertions.assertEquals(updatedMessage, commentSelected.getMessage());

        // delete
        commentMapper.delComment(commentId);
        Assertions.assertNull(commentMapper.getComment(commentId));
    }
}
