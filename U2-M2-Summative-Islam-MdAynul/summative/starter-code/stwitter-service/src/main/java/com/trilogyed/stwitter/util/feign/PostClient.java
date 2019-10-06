package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @PostMapping(value = "/posts")
    Post createPost(@RequestBody Post post);

    @GetMapping(value = "/posts")
    List<Post> getPosts();

    @GetMapping(value = "/posts/{id}")
    Post getPost(@PathVariable int id);

    @PutMapping(value = "/posts/{id}")
    void updatePost(@PathVariable int id, @RequestBody Post post);

    @DeleteMapping(value = "/posts/{id}")
    public void deletePost(@PathVariable int id);

    @GetMapping(value = "/posts/poster/{posterName}")
    public List<Post> getPostsByPoster(@PathVariable String posterName);
}
