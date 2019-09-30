package com.trilogyed.comment.service;


import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.repository.CommentRepository;
import com.trilogyed.comment.viewmodel.CommentViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ServiceLayer {

    private CommentRepository repo;


    @Autowired
    public ServiceLayer(CommentRepository repo) {
        this.repo = repo;

    }

    //Create Comment
    public  CommentViewModel createComment(CommentViewModel cvm){

        Comment comment= new Comment();
        comment.setPostId(cvm.getPostId());
        comment.setCreateDate(cvm.getCreateDate());
        comment.setCommenterName(cvm.getCommenterName());
        comment.setComment(cvm.getComment());

        comment= repo.save(comment);
        cvm.setCommentId(comment.getCommentId());

        return cvm;
    }

    //Read Comment

    public  CommentViewModel readComment(int id){
        Comment comment = repo.getOne(id);

        if(comment == null){
            throw new NumberFormatException("Can't find comment with that id number: "+ id+ ". " +
                    "Perhaps your input was not a number.");

        }
        return buildCommentViewModel(comment);
    }

    //Read All Comment

    public List<CommentViewModel> readAllComments(){
        List<Comment> comments = repo.findAll();
        List<CommentViewModel> cList = new ArrayList<>();

        comments.stream()
                .forEach(comment -> {
                    CommentViewModel cvm = buildCommentViewModel(comment);
                    cList.add(cvm);
                });


        return cList;
    }

    //update Comment

    public CommentViewModel updateComment(CommentViewModel cvm) {
        Comment c = new Comment();
        c.setCommentId(cvm.getCommentId());
        c.setPostId(cvm.getPostId());
        c.setCreateDate(cvm.getCreateDate());
        c.setCommenterName(cvm.getCommenterName());
        c.setComment(cvm.getComment());

         repo.save(c);
        cvm.setCommentId(c.getCommentId());

        Optional<Comment> comment = repo.findById(cvm.getCommentId());


        CommentViewModel commentViewModel = new CommentViewModel();

        commentViewModel.setCommentId(comment.get().getCommentId());
        commentViewModel.setPostId(comment.get().getPostId());
        commentViewModel.setCreateDate(comment.get().getCreateDate());
        commentViewModel.setCommenterName(comment.get().getCommenterName());
        commentViewModel.setComment(comment.get().getComment());

        return commentViewModel;
    }

    //delete Comment

    public void deleteComment(int id){
        repo.deleteById(id);
    }


    /*******************************Helper Method*****************************************/

    public CommentViewModel buildCommentViewModel(Comment comment){
        CommentViewModel cvm = new CommentViewModel();
        if(comment == null){
            cvm = null;
        }else{
            cvm.setCommentId(comment.getCommentId());
            cvm.setPostId(comment.getPostId());
            cvm.setCreateDate(comment.getCreateDate());
            cvm.setCommenterName(comment.getCommenterName());
            cvm.setComment(comment.getComment());
        }

        return cvm;
    }

}
