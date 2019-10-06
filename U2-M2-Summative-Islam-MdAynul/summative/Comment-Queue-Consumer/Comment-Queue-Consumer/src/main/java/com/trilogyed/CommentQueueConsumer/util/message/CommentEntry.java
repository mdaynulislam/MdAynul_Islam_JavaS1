package com.trilogyed.CommentQueueConsumer.util.message;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CommentEntry {

    //Comment Properties
    private int commentId;
    private int postId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public CommentEntry(){} // Default constructor Jackson need it to convert the message

    //constructor

    public CommentEntry(int commentId, int postId, String commenterName, LocalDate createDate, LocalDate commentDate, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.commenterName = commenterName;
        this.createDate = createDate;
        this.comment = comment;
    }


    //getters and setters

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

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    //toString method


    @Override
    public String toString() {
        return "CommentEntry{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
