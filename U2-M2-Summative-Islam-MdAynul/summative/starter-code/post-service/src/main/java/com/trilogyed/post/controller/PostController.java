package com.trilogyed.post.controller;

import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.service.ServiceLayer;
import com.trilogyed.post.viewModel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CacheConfig(cacheNames = {"posts"})
@RefreshScope
@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    ServiceLayer service;


    @PostMapping
    @CachePut(key = "#result.getPostId")
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody PostViewModel pvm) {

        return service.createPost(pvm);

    }

    @GetMapping("/{id}")
    @Cacheable
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable("id") int id) {
        PostViewModel pvm = service.getPost(id);
        if (pvm == null)
            throw new NotFoundException("Cannot find id: " + id);
        return pvm;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getAllPosts(){
        return service.getAllPosts();
    }

    @CacheEvict
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePost(@PathVariable("id") int id){
        service.removePost(id);
        return "Post successfully deleted.";
    }


    @PutMapping("/{id}")
    @CacheEvict(key = "#pvm.getPostId()")
    @ResponseStatus(HttpStatus.OK)
    public String updatePost(@PathVariable("id") int id, @RequestBody PostViewModel pvm) {
        service.updatePost(pvm);
        return "Post successfully updated.";
    }


    @RequestMapping(value = "/user/{postername}", method = RequestMethod.GET)
    public List<PostViewModel> getPostByPosterName( @PathVariable("postername") String posterName) {

        List<PostViewModel> pvmList = service.getPostByPosterName(posterName);
        if (pvmList.size() == 0)
            throw new NotFoundException("Cannot find poster: " + posterName);
        return pvmList;
    }
}
