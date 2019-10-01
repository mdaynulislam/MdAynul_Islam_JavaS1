package com.trilogyed.stwitter.viewModel;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostCommentViewModel {
    private int postId;
    @Size(min = 2, message = "Too short post")
    private String post;
    private LocalDate postDate;
    @Size(max= 50, message = "too big for a poster name")
    private String posterName;
    private List<String> comments;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostCommentViewModel)) return false;
        PostCommentViewModel that = (PostCommentViewModel) o;
        return getPostId() == that.getPostId() &&
                getPost().equals(that.getPost()) &&
                getPostDate().equals(that.getPostDate()) &&
                getPosterName().equals(that.getPosterName()) &&
                getComments().equals(that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getPost(), getPostDate(), getPosterName(), getComments());
    }
}
