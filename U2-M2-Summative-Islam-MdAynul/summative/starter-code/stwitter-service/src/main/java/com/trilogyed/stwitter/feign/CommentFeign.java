package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
@RequestMapping("/comments")
public interface CommentFeign {

    @PostMapping
    Comment createComment(@RequestBody Comment comment);

    @GetMapping("/{id}")
    Comment getComment(@PathVariable("id") int id);

    @DeleteMapping("/{id}")
    void deleteComment(@PathVariable("id") int id);

    @GetMapping("/id")
    public List<Comment> getCommentByPostId(@PathVariable(name = "{id}") int postId);





}
