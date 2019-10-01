package com.trilogyed.comment.dao.service;


import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.dao.CommentDaoJdbcImpl;
import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.service.ServiceLayer;
import com.trilogyed.comment.viewmodel.CommentViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ServiceLayerTest {

    CommentDao commentDao;
    ServiceLayer service;

    @Before
    public void setUp() throws Exception{

        setUpCommentDaoMock();

        service = new ServiceLayer(commentDao);
    }


    @Test
    public void createComment() {
        CommentViewModel commentViewModel = new CommentViewModel();
        // add the first Comment from the add comment Mock
        commentViewModel.setPostId(1);
        commentViewModel.setCreateDate(String.valueOf(LocalDate.of(2019,9,26)));
        commentViewModel.setCommenterName("Leonardo");
        commentViewModel.setComment("That is dashing post.");
        commentViewModel= service.createComment(commentViewModel);
        CommentViewModel fromService= service.getComment(commentViewModel.getCommentId());
        assertEquals(commentViewModel,fromService);
    }
    @Test
    public void getComment() {
        //Taking the first Comment from the CommentMock
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Leonardo");
        comment.setComment("That is dashing post.");
        //add to the comment view model
        CommentViewModel commentViewModel = service.getComment(1);
        Comment comment1 = new Comment();
        comment1.setCommentId(commentViewModel.getCommentId());
        comment1.setPostId(commentViewModel.getPostId());
        comment1.setCreateDate(LocalDate.parse(commentViewModel.getCreateDate()));
        comment1.setCommenterName(commentViewModel.getCommenterName());
        comment1.setComment(commentViewModel.getComment());
        assertEquals(comment1,comment);
    }
    @Test
    public void readAllComments() {
        //getting all the comment from the CommentViewModel
        List<CommentViewModel> fromService = service.getAllComments();
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
        commentViewUpdate.setCreateDate(String.valueOf(updateComment.getCreateDate()));
        commentViewUpdate.setCommenterName(updateComment.getCommenterName());
        commentViewUpdate.setComment(updateComment.getComment());
        CommentViewModel cvm = service.updateComment(commentViewUpdate);
        //finding the comment we just updated
        CommentViewModel commentViewModel = service.getComment(2);
        //passing the updated Comment into commentAfterUpdate object
        Comment commentAfterUpdate= new Comment();
        commentAfterUpdate.setCommentId(commentViewModel.getCommentId());
        commentAfterUpdate.setPostId(commentViewModel.getPostId());
        commentAfterUpdate.setCreateDate(LocalDate.parse(commentViewModel.getCreateDate()));
        commentAfterUpdate.setCommenterName(commentViewModel.getCommenterName());
        commentAfterUpdate.setComment(commentViewModel.getComment());
        //comparing both comment
        assertEquals(commentAfterUpdate,afterUpdate);
    }
    @Test
    public void deleteComment() {
        Comment deleteMock = new Comment();
        deleteMock.setCommentId(3);
        deleteMock.setPostId(1);
        deleteMock.setCreateDate(LocalDate.of(2019,9,26));
        deleteMock.setCommenterName("deleted");
        deleteMock.setComment("That is dashing post deleted.");
        commentDao.createComment(deleteMock);
        commentDao.deleteComment(3);
        assertNull(commentDao.getComment(3));
    }
    /********************************** DAO MOCK *****************************************/
    private void setUpCommentDaoMock(){
        commentDao = mock(CommentDaoJdbcImpl.class);
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
        doReturn(comment).when(commentDao).createComment(comment1);
//        doReturn(comment).when(commentDao).getComment(comment.getCommentId());
        //Mock the get Comment
        doReturn(comment).when(commentDao).getComment(1);
        //MOck the getAll comment
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        doReturn(commentList).when(commentDao).getAllComments();
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
//        Optional <Comment> optional = Optional.of(afterUpdate);
        doReturn(afterUpdate).when(commentDao).createComment(updateComment);
//        doReturn(optional).when(repository).findById(2);
        doReturn(afterUpdate).when(commentDao).getComment(2);
        //delete mock
        doNothing().when(commentDao).deleteComment(3);
    }


}
