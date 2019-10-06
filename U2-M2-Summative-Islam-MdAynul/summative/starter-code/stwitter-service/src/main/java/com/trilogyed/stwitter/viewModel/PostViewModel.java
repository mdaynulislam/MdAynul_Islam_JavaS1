package com.trilogyed.stwitter.viewModel;

import com.trilogyed.stwitter.model.Comment;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {
    private int postId;
    private LocalDate postDate;
    @Size(min = 2, message = "Too short for a poster Name")
    private String posterName;
    @Size(min = 2, message = "Too short for a Post")
    private String post;
    private List<Comment> comments;

    //getters and setters

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    //Equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postId == that.postId &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                post.equals(that.post) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, post, comments);
    }
}
