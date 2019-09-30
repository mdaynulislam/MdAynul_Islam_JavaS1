package com.trilogyed.comment.serviceLayerTest;

import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.repository.CommentRepository;
import com.trilogyed.comment.service.ServiceLayer;
import com.trilogyed.comment.viewmodel.CommentViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    CommentRepository repository;

    ServiceLayer service;

    @Before
    public void setUp() throws Exception {
        setUpCommentMock();
        service = new ServiceLayer(repository);
    }

    @Test
    public void createComment() {

        CommentViewModel commentViewModel = new CommentViewModel();
        // add the first Comment from the add comment Mock

        commentViewModel.setPostId(1);
        commentViewModel.setCreateDate(LocalDate.of(2019,9,26));
        commentViewModel.setCommenterName("Leonardo");
        commentViewModel.setComment("That is dashing post.");

        commentViewModel= service.createComment(commentViewModel);

        CommentViewModel fromService= service.readComment(commentViewModel.getCommentId());
        assertEquals(commentViewModel,fromService);
    }

    @Test
    public void readComment() {
        //Taking the first Comment from the CommentMock
        Comment comment = new Comment();

        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Leonardo");
        comment.setComment("That is dashing post.");

        //add to the comment view model
        CommentViewModel commentViewModel = service.readComment(1);

        Comment comment1 = new Comment();

        comment1.setCommentId(commentViewModel.getCommentId());
        comment1.setPostId(commentViewModel.getPostId());
        comment1.setCreateDate(commentViewModel.getCreateDate());
        comment1.setCommenterName(commentViewModel.getCommenterName());
        comment1.setComment(commentViewModel.getComment());

        assertEquals(comment1,comment);
    }

    @Test
    public void readAllComments() {
        //getting all the comment from the CommentViewModel
        List<CommentViewModel> fromService = service.readAllComments();
        assertEquals(1,fromService.size());
    }

    @Test
    public void updateComment() {

        CommentViewModel commentViewUpdate= new CommentViewModel();

        //taking the comment form the update chunk

        Comment updateComment= new Comment();

        updateComment.setCommentId(2);
        updateComment.setPostId(1);
        updateComment.setCreateDate(LocalDate.of(2019,9,26));
        updateComment.setCommenterName("Updated");
        updateComment.setComment("That's Updated");


        Comment afterUpdate = new Comment();

        afterUpdate.setCommentId(2);
        afterUpdate.setPostId(1);
        afterUpdate.setCreateDate(LocalDate.of(2019,9,26));
        afterUpdate.setCommenterName("after update commenterName");
        afterUpdate.setComment("after update comment");

        //passing into the CommentViewModel\

        commentViewUpdate.setCommentId(updateComment.getCommentId());
        commentViewUpdate.setPostId(updateComment.getPostId());
        commentViewUpdate.setCreateDate(updateComment.getCreateDate());
        commentViewUpdate.setCommenterName(updateComment.getCommenterName());
        commentViewUpdate.setComment(updateComment.getComment());

        CommentViewModel cvm=service.updateComment(commentViewUpdate);


        //finding the comment we just updated
        CommentViewModel commentViewModel = service.readComment(2);

        //passing the updated Comment into commentAfterUpdate object

        Comment commentAfterUpdate= new Comment();

        commentAfterUpdate.setCommentId(commentViewModel.getCommentId());
        commentAfterUpdate.setPostId(commentViewModel.getPostId());
        commentAfterUpdate.setCreateDate(commentViewModel.getCreateDate());
        commentAfterUpdate.setCommenterName(commentViewModel.getCommenterName());
        commentAfterUpdate.setComment(commentViewModel.getComment());

        //comparing both comment
        assertEquals(commentAfterUpdate,afterUpdate);

    }

    @Test
    public void deleteComment() {

        Comment deleteMock= new Comment();
        deleteMock.setCommentId(3);
        deleteMock.setPostId(1);
        deleteMock.setCreateDate(LocalDate.of(2019,9,26));
        deleteMock.setCommenterName("deleted");
        deleteMock.setComment("That is dashing post deleted.");

        repository.save(deleteMock);

        repository.deleteById(3);

        assertFalse(repository.findById(3).isPresent());
    }

    /********************************** DAO MOCK *****************************************/


    private void setUpCommentMock(){
        repository = mock(CommentRepository.class);

        //Mock add Comment
        Comment comment = new Comment();

        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Leonardo");
        comment.setComment("That is dashing post.");

        //creating another Comment object without the id

        Comment comment1 = new Comment();

        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019,9,26));
        comment1.setCommenterName("Leonardo");
        comment1.setComment("That is dashing post.");

        doReturn(comment).when(repository).save(comment1);
        doReturn(comment).when(repository).getOne(comment.getCommentId());

        //Mock the get Comment
        doReturn(comment).when(repository).getOne(1);


        //MOck the getAll comment
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        doReturn(commentList).when(repository).findAll();

        //Mock the update

        Comment updateComment= new Comment();

        updateComment.setCommentId(2);
        updateComment.setPostId(1);
        updateComment.setCreateDate(LocalDate.of(2019,9,26));
        updateComment.setCommenterName("Updated");
        updateComment.setComment("That's Updated");

        Comment afterUpdate = new Comment();

        afterUpdate.setCommentId(2);
        afterUpdate.setPostId(1);
        afterUpdate.setCreateDate(LocalDate.of(2019,9,26));
        afterUpdate.setCommenterName("after update commenterName");
        afterUpdate.setComment("after update comment");

        Optional <Comment> optional = Optional.of(afterUpdate);


        doReturn(afterUpdate).when(repository).save(updateComment);
        doReturn(optional).when(repository).findById(2);
        doReturn(afterUpdate).when(repository).getOne(2);

        //delete mock
        doNothing().when(repository).deleteById(3);

    }

}
