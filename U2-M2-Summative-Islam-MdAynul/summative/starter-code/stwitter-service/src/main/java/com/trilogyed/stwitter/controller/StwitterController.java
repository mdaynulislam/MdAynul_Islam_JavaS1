package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import com.trilogyed.stwitter.viewModel.PostCommentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/posts")
public class StwitterController {

    @Autowired
    ServiceLayer service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostCommentViewModel createPost(@RequestBody PostCommentViewModel post) {

        return service.createPost(post);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostCommentViewModel getPost(@PathVariable("id") int id) {
        PostCommentViewModel pvm = service.getPost(id);
        if (pvm == null)
            throw new NotFoundException("Cannot find id: " + id);
        return pvm;
    }

    @RequestMapping(value = "/user/{postername}", method = RequestMethod.GET)
    public List<PostCommentViewModel> getPostByPosterName(@PathVariable("postername") String posterName) {

        List<PostCommentViewModel> pvmList = service.getPostByPosterName(posterName);
        if (pvmList.size() == 0)
            throw new NotFoundException("Cannot find poster: " + posterName);
        return pvmList;
    }


    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment(@RequestBody CommentViewModel cvm) {

        return service.createComment(cvm);

    }
}
