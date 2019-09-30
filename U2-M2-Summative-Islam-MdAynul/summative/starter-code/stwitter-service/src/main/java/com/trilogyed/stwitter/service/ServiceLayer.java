package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentFeign;
import com.trilogyed.stwitter.feign.PostFeign;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ServiceLayer {

    PostFeign pClient;
    CommentFeign cClient;

    @Autowired
    public ServiceLayer(PostFeign pClient, CommentFeign cClient) {
        this.pClient = pClient;
        this.cClient = cClient;
    }



    public PostViewModel createPost(PostViewModel pvm) {
        Post post = new Post();

        post.setPostDate(pvm.getPostDate());
        post.setPosterName(pvm.getPosterName());
        post.setPost(pvm.getPost());
        post.setPosterName(pvm.getPosterName());



    }
/*****************************Helper Method**********************************************/
    private PostViewModel buildPostViewModel(Post post) {

        PostViewModel pvm = new PostViewModel();
        Comment comment = new Comment();

        pvm.setPostId(post.getPostId());
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());

        List<Comment> commentList = cClient.getCommentByPostId(pvm.getPostId());

        List<String> comments = new ArrayList<>();
        for (Comment c : commentList) {
            comments.add(c.getComment());
        }

        pvm.setComments(comments);

        return pvm;
    }
}
