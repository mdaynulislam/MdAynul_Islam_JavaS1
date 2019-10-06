package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentClient;
import com.trilogyed.stwitter.util.feign.PostClient;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    //Feign Clients
    PostClient postClient;
    CommentClient commentClient;

    //Constructor
    public ServiceLayer(PostClient postClient, CommentClient commentClient) {
        this.postClient = postClient;
        this.commentClient = commentClient;
    }

    //For The Post

    public PostViewModel savePost(Post post) {
        post = postClient.createPost(post);
        return buildPostViewModel(post);
    }

    public PostViewModel findPost(int id) {
        Post post = postClient.getPost(id);
        if (post == null) {
            throw new NotFoundException("Sorry, we cannot find a post with that id. ");
        }
        return buildPostViewModel(post);
    }

    //For the Comment

    public List<Comment> findAllComments() {
        return commentClient.getAllComments();
    }

    public List<Comment> findAllCommentsByCommenter(String commenterName) {
        return commentClient.getCommentsByCommenter(commenterName);
    }

    public Comment findCommentById(int id) {
        return commentClient.getCommentById(id);
    }

    public void removeComment(int id) {
        commentClient.deleteComment(id);
    }

    public List<PostViewModel> findAllPosts() {
        List<Post> posts = postClient.getPosts();
        List<PostViewModel> pvmList = new ArrayList<>();

        for(Post p: posts) {
            PostViewModel pvm = buildPostViewModel(p);
            pvmList.add(pvm);
        }

        return pvmList;
    }

    public List<PostViewModel> findPostsByPoster(String posterName) {
        List<Post> posts = postClient.getPostsByPoster(posterName);
        List<PostViewModel> pvmList = new ArrayList<>();

        for(Post p: posts) {
            PostViewModel pvm = buildPostViewModel(p);
            pvmList.add(pvm);
        }

        return pvmList;
    }

    public void updatePost(Post post) {
        postClient.updatePost(post.getPostId(), post);
    }

    public void removePost(int id) {
        postClient.deletePost(id);
    }
    public List<Comment> findCommentsByPostId(int id) {
        return commentClient.getCommentsByPostId(id);
    }
    /*********************************Helper Method ********************************/

    private  PostViewModel buildPostViewModel(Post post){

        PostViewModel postViewModel = new PostViewModel();

        postViewModel .setPostId(post.getPostId());
        postViewModel.setPostDate(post.getPostDate());
        postViewModel.setPosterName(post.getPosterName());
        postViewModel.setPost(post.getPost());

        //for the comments
        List<Comment> comments = findCommentsByPostId(post.getPostId());
        postViewModel.setComments(comments);

        return postViewModel;
    }
}
