package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostDao postDao;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody @Valid Post post){
        return postDao.addPost(post);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable int id){
        return postDao.getPost(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody Post post, @PathVariable int id){
        postDao.updatePost(post);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id){
        postDao.deletePost(id);
    }

    @GetMapping(value = "/user/posterName")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPostsByPoster(@PathVariable String posterName){
        return postDao.getPostsByPoster(posterName);
    }



}
