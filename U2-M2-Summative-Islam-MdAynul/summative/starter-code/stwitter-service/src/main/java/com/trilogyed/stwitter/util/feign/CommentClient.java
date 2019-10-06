package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClient {

    @GetMapping("/comments")
    List<Comment> getAllComments();

    @GetMapping("/comments/{id}")
    Comment getCommentById(@PathVariable int id);

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable int id);

    @GetMapping("/commenter/{commenterName}")
    List<Comment> getCommentsByCommenter(@PathVariable String commenterName);

    @GetMapping("/comments/post/{postId}")
    List<Comment> getCommentsByPostId(@PathVariable int postId);


}
