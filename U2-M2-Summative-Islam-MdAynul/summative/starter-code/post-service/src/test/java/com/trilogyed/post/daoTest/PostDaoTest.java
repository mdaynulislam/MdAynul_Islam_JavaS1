package com.trilogyed.post.daoTest;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> post = postDao.getAllPosts();
        for (Post p : post) {
            postDao.deletePost(p.getPostId());
        }

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019,9,26));
        post.setPosterName("Gravity Launch");
        post.setPost("Gravity");

        post = postDao.addPost(post);

        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post1,post);

        postDao.deletePost(post.getPostId());
        post1 = postDao.getPost(post.getPostId());
        assertNull(post1);
    }


    @Test
    public void getAllPosts() {

        Post post = new Post();
        post.setPostDate(LocalDate.of(2019,9,26));
        post.setPosterName("Martian");
        post.setPost("Mat Demon");

        post = postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019,8,24));
        post.setPosterName("Martian 2");
        post.setPost("Scott Adkins");

        postDao.addPost(post);

        List<Post> pList = postDao.getAllPosts();
        assertEquals(2, pList.size());
    }

    @Test
    public void updatePost() {

        Post post = new Post();
        post.setPostDate(LocalDate.of(2019,9,26));
        post.setPosterName("Terminator");
        post.setPost("Arnold");
        post = postDao.addPost(post);

        post.setPost("Arnold updated");
        postDao.updatePost(post);

        Post post1 = postDao.getPost(post.getPostId());
        assertEquals(post1,post);
    }

    @Test
    public void getPostByPosterName() {


        Post post = new Post();
        post.setPostDate(LocalDate.of(2019,9,26));
        post.setPosterName("Phantom");
        post.setPost("It is here");

        post = postDao.addPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2019,9,26));
        post.setPosterName("Phantom");
        post.setPost("It is here");

        post = postDao.addPost(post);

        List<Post> pList = postDao.getPostsByPoster("Phantom");
        assertEquals(2,pList.size());



    }

}