package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.message.CommentEntry;
import com.trilogyed.stwitter.viewModel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RefreshScope
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"posts"})
public class StwitterController {

    private ServiceLayer service;
    private RabbitTemplate rabbitTemplate;

    public StwitterController(ServiceLayer service, RabbitTemplate rabbitTemplate) {
        this.service = service;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.comment.controller";


    /*******************************POST ENDPOINTS***********************************/

    @CachePut(key = "#result.getPostId()") // will cache the result of this method
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody @Valid Post post){
        return service.savePost(post);
    }

    @Cacheable // can be cache if the method is invoked
    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return service.findPost(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PostViewModel> getAllPosts() {
        return service.findAllPosts();
    }

    @CacheEvict(key = "#post.getPostId()") // will remove from the cache
    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody @Valid Post post) {
        if (post.getPostId() == 0) {
            post.setPostId(id);
        }
        if (id != post.getPostId()) {
            throw new IllegalArgumentException("No associated post found with the given id!");
        }
        service.updatePost(post);
    }

    @CacheEvict// will remove from the cache
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        service.removePost(id);
    }



    /*******************************COMMENT ENDPOINTS*********************************/

    @PostMapping(value = "/comments")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createComment(@RequestBody @Valid CommentEntry commentEntry) {

        //For the QUEUE while creating comment
        System.out.println("Sending message....");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
        System.out.println("Message sent. " + commentEntry.toString());
    }

    @GetMapping("/comments/{id}")
    @ResponseStatus( value = HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        Comment comment = service.findCommentById(id);
        if (comment == null) {
            throw new NotFoundException("Couldn't find a comment with the id.");
        }
        return comment;
    }

    @GetMapping(value = "/comments")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }

    @PutMapping(value = "/comments/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody @Valid CommentEntry commentEntry) {
        if (commentEntry.getCommentId() == 0) {
            commentEntry.setCommentId(id);
        }
        if (id != commentEntry.getCommentId()) {
            throw new IllegalArgumentException("Comment Id in object & path much match!");
        }
        //For the QUEUE while updating comment
        System.out.println("Sending message....");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, commentEntry);
        System.out.println();
    }

    @DeleteMapping(value = "/comments/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id) {
        service.removeComment(id);
    }

    @GetMapping(value = "/comments/post/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        List<Comment> comments = service.findCommentsByPostId(postId);
        if (comments == null) {
            throw new NotFoundException("Couldn't find a comment with the id.");
        }
        return comments;
    }

    @GetMapping(value = "/comments/user/{commenterName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentsByCommenter(@PathVariable String commenterName) {
        List<Comment> comments = service.findAllCommentsByCommenter(commenterName);
        if (comments == null) {
            throw new NotFoundException("Couldn't find a comment with the id.");
        }
        return comments;
    }



}
