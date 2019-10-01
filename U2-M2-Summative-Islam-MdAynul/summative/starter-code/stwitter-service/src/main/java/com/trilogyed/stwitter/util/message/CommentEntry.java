package com.trilogyed.stwitter.util.message;

import java.time.LocalDate;

public class CommentEntry {

    //Comment Properties without the commentId


    private int postId;
    private String commenterName;
    private String createDate;
    private String comment;

    public CommentEntry(){} // Default constructor Jackson need it to convert the message

    //constructor

    public CommentEntry(int postId, String commenterName, String createDate, String comment) {
        this.postId = postId;
        this.commenterName = commenterName;
        this.createDate = createDate;
        this.comment = comment;
    }


    //getters and setters

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
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
                "postId=" + postId +
                ", commenterName='" + commenterName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
