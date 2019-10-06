package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RefreshScope // by the actuator which refresh all the beans in the scope by clearing the target cache
@RequestMapping("/comments")
public class CommentController {


    @Autowired
    CommentDao commentDao;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment){
        return commentDao.addComment(comment);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment findCommentById(@PathVariable int id){
        return commentDao.getComment(id);
    }
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findAllComments(){
        return commentDao.getAllComments();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody Comment comment){
        commentDao.updateComment(comment);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id){
        commentDao.deleteComment(id);
    }

    @GetMapping(value = "/post/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentByPostId(@PathVariable int postId){
       return commentDao.getCommentByPostId(postId);

    }

    @GetMapping(value = "/commenter/{commenterName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentByCommenterName(@PathVariable String commenterName){
        return commentDao.getCommentByCommenterName(commenterName);
    }

}
