package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.viewModel.CommentViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
@RequestMapping("/comments")
public interface CommentFeign {

    @PostMapping
    CommentViewModel createComment(@RequestBody CommentViewModel cvm);

    @GetMapping("/{id}")
    CommentViewModel getComment(@PathVariable("id") int id);

    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable("id") int id);

    @GetMapping("/poster/{id}")
    public List<CommentViewModel> getCommentByPostId(@PathVariable(name="id") int postId);




}
