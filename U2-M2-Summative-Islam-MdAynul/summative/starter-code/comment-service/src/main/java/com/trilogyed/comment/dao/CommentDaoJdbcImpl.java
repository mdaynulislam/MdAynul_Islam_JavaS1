package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcImpl implements CommentDao{

    //prepare statement

    private static final String INSERT_COMMENT_SQL=
            "insert into comment (post_id, create_date, commenter_name, comment) values (?, ?, ?, ?)";
    private static final String SELECT_COMMENT_SQL=
            "select * from comment where comment_id = ?";
    private static final String SELECT_ALL_COMMENTS_SQL=
            "select * from comment";
    private static final String UPDATE_COMMENT_SQL=
            "update comment set post_id = ?, create_date =?, commenter_name = ?, comment = ? where comment_id = ?";
    private static final String DELETE_COMMENT_SQl=
            "delete from comment where comment_id =?";
    private static final String SELECT_COMMENTS_BY_POST_SQL=
            "select * from comment where post_id=?";
    private static final String SELECT_COMMENT_BY_COMMENTER_SQL=
            "select * from comment where commenter_name = ?";

    private JdbcTemplate jdbcTemplate; // dependency injection

    //constructor

    @Autowired
    public CommentDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Map to Row in order to communicate with the database

    private Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));
        return comment;
    }

    @Override
    @Transactional // it will consider all the changes as one
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());

        //getting the last id by database which is auto generated
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(id);
        return comment;
    }

    @Override
    public Comment getComment(int commentId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL,this::mapRowToComment, commentId);
        }catch (EmptyResultDataAccessException e){
            //if no comment is found it will return null
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SELECT_ALL_COMMENTS_SQL, this::mapRowToComment);
    }

    @Override
    public void updateComment(Comment comment) {
        jdbcTemplate.update(UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId()); //Lastly the commentId
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(DELETE_COMMENT_SQl, commentId);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        try {
            return jdbcTemplate.query(SELECT_COMMENTS_BY_POST_SQL,this::mapRowToComment, postId);
        }catch (EmptyResultDataAccessException e){
            //if no comment found with postId it will return null
            return null;
        }
    }

    @Override
    public List<Comment> getCommentByCommenterName(String commenterName) {

        try {
            return jdbcTemplate.query(SELECT_COMMENT_BY_COMMENTER_SQL,this::mapRowToComment,commenterName);
        }catch (EmptyResultDataAccessException e){
            //if no comment found by commenter name it will return null
            return null;
        }
    }


}
