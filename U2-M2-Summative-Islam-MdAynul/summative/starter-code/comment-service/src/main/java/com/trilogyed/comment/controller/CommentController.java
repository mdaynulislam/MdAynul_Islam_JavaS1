package com.trilogyed.comment.controller;


import com.trilogyed.comment.exception.NotFoundException;
import com.trilogyed.comment.service.ServiceLayer;
import com.trilogyed.comment.viewmodel.CommentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class CommentController {


    @Autowired
    private ServiceLayer service;

   //Create comment

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public CommentViewModel createComment (@RequestBody @Valid CommentViewModel cvm){

        return service.createComment(cvm);
    }

   //read comment

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public CommentViewModel readComment(@PathVariable int id){
        CommentViewModel cvm = service.readComment(id);

        if (cvm == null)
            throw new NotFoundException("Cannot find your comment with that id number: "+ id+ ".");
        return cvm;
    }

    //Read all Comment

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CommentViewModel> readAllComments(){

        return service.readAllComments();
    }

   //Update Comment
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public String updateComment(@PathVariable int id, @RequestBody CommentViewModel cvm){
        if (cvm.getCommentId() == 0)
            cvm.setCommentId(id);
        if (id != cvm.getCommentId()) {
            throw new IllegalArgumentException("The id doesn't match with the existing data");
        }
        service.updateComment(cvm);

        return "Your comment has been updated.";
    }

    //delete Comment

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteComment(@PathVariable int id){

        service.deleteComment(id);

        return "Comment has been deleted";
    }

}
