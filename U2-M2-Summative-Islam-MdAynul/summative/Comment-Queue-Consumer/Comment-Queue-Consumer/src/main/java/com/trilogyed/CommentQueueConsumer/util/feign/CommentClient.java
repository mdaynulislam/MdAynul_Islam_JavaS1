package com.trilogyed.CommentQueueConsumer.util.feign;

import com.trilogyed.CommentQueueConsumer.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "comment-service")
public interface CommentClient {

    @PostMapping(value = "/comments")
    void saveComment(@RequestBody Comment comment);

    @PutMapping (value = "/comments/{id}")
    void updateComment(@PathVariable int id, @RequestBody Comment comment);
}
