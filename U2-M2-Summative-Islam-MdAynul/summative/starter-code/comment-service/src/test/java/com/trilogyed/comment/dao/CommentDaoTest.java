package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Before
    public void setUp() throws Exception {
        List<Comment> comments = commentDao.getAllComments();
        for (Comment c : comments) {
            commentDao.deleteComment(c.getCommentId());
        }

    }


    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void addGetDeletePost() {

        //populating the comment
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Neo");
        comment.setComment("There is no spoon");

        comment = commentDao.addComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);

        commentDao.deleteComment(comment.getCommentId());
        comment1 = commentDao.getComment(comment.getCommentId());
        assertNull(comment1);
    }

    @Test
    public void getAllComments() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Neo");
        comment.setComment("There is no spoon");

        comment = commentDao.addComment(comment);

        List<Comment> commentList = commentDao.getAllComments();
        assertEquals(1, commentList.size());

    }

    @Test
    public void updateComment() {

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Neo");
        comment.setComment("There is no spoon");

        comment = commentDao.addComment(comment);

        comment.setCreateDate(LocalDate.of(2019,8,20));
        comment.setComment("It's just updated");

        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);
    }


    @Test
    public void getCommentByPostId() {


        Comment comment = new Comment();
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Da Vinci");
        comment.setComment("Smile of Monalisa");

        commentDao.addComment(comment);

        List<Comment> commentListList = commentDao.getCommentByPostId(2);
        assertEquals(1,commentListList.size());

    }

    @Test
    public void getCommentsByCommenterName(){

        //populating the comment
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Neo");
        comment.setComment("There is no spoon");

        comment = commentDao.addComment(comment);

        List<Comment> commentList = commentDao.getCommentByCommenterName("Neo");
        assertEquals(1,commentList.size());

    }
}