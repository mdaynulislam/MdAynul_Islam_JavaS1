package com.trilogyed.stwitter.util.message;

import java.time.LocalDate;

public class CommentEntry {

    //Comment Properties without the commentId


    private int postId;
    private String createDate;
    private String commenterName;
    private String comment;

    public CommentEntry(){} // Default constructor Jackson need it to convert the message

    //constructor

    public CommentEntry( int postId, String createDate, String commenterName, String comment) {

        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
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
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
