package com.example.weatherking.comment.data;

import com.example.weatherking.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {
    // PK
    private Long commentId;
    private String message;
    @JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
    private Date createAt;

    // 댓글 수정 기록
    private Boolean isUpdated;
    @JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
    private Date updateAt;

    // 댓글 삭제 기록
    private Boolean isDeleted;
    @JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
    private Date deleteAt;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Boolean getIsUpdated() {
        return isUpdated;
    }

    public void setIsUpdated(Boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", createAt=" + createAt +
                ", isUpdated=" + isUpdated +
                ", updateAt=" + updateAt +
                ", isDeleted=" + isDeleted +
                ", deleteAt=" + deleteAt +
                '}';
    }
}
