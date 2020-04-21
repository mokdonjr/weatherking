package com.example.weatherking.comment.repository;

import com.example.weatherking.comment.data.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    /**
     * COMMENT 데이터
     */
    int insComment(@Param("comment") Comment comment);
    int updComment(@Param("comment") Comment comment);
    int delComment(@Param("commentId") long commentId);
    Comment getComment(@Param("commentId") long commentId);
    Comment getCommentForUpdate(@Param("commentId") long commentId);
    Comment getCommentLastOne();
    Comment getCommentLastOneNotDeleted();
    List<Comment> getCommentList();
    List<Comment> getCommentListNotDeleted();
}
