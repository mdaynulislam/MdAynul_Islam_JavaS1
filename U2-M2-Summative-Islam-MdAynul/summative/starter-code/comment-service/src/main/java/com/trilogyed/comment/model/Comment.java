package com.trilogyed.comment.model;

import java.time.LocalDate;
import java.util.Objects;


public class Comment {

    private int commentId;
    private int postId;
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;

    }

    //Equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return commentId == comment1.commentId &&
                postId == comment1.postId &&
                createDate.equals(comment1.createDate) &&
                commenterName.equals(comment1.commenterName) &&
                comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, createDate, commenterName, comment);
    }


}
