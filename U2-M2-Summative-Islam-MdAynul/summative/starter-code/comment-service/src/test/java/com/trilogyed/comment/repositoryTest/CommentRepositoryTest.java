package com.trilogyed.comment.repositoryTest;


import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.repository.CommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository repo;

    @Test
    public void createTest() throws Exception{

        repo.deleteAll();

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Leonardo");
        comment.setComment("That is dashing post.");

        repo.save(comment);
        List<Comment> cList= repo.findAll();
        assertEquals(1, cList.size());



    }

    @Test
    public void updateTest() throws Exception{
        repo.deleteAll();

        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,25));
        comment.setCommenterName("Robert Downey Jr");
        comment.setComment("Cool dude.");

        repo.save(comment);


        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,26));
        comment.setCommenterName("Scarlett");
        comment.setComment("Ohhh man!");

        repo.save(comment);

        Optional<Comment> comments = repo.findById(comment.getCommentId());

        Comment c = null;
        if(comments.isPresent()==true){
            c= comments.get();
        }

        assertEquals(comment, c);

    }



    @Test
    public void deleteTest() throws Exception{
        repo.deleteAll();


        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,9,25));
        comment.setCommenterName("James Cameron");
        comment.setComment("film maker iq.");

        repo.save(comment);

        Comment comment2 = new Comment();
        comment2.setPostId(2);
        comment2.setCreateDate(LocalDate.of(2019,9,25));
        comment2.setCommenterName("Will Smith");
        comment2.setComment(" I am Legend.");

        repo.save(comment2);
        repo.delete(comment);

        List<Comment> comments = repo.findAll();
        assertEquals(comments.size(),1);
    }

}
