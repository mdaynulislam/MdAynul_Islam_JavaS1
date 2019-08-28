package com.company.MdAynulIslamU1M5Summative.dao;
import com.company.MdAynulIslamU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {

    //Prepare Statement

    // add Author
    private static final String INSERT_AUTHOR_SQL =
            "insert into author(first_name, last_name, street, city, state, postal_code, phone, email) values (?, ?, ?, ?, ?, ?, ?, ?)";

    //get Author
    private static final String SELECT_AUTHOR_SQL=
            "select * from author where author_id = ?";

    //get all Authors
    private static final String SELECT_ALL_AUTHORS_SQL=
            "select * from author";

    //update Author
    private static final String UPDATE_AUTHOR_SQL=
            "update author set first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?  where author_id = ?";

    //delete Author
    private static final String DELETE_AUTHOR=
            "delete from author where author_id = ?";

    private JdbcTemplate jdbcTemplate; // injecting jdbc template to interact with the database

    @Autowired // constructor for jdbc
    public AuthorDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //Mapping between row and object according to the database table

    private Author mapRowToAuthor(ResultSet rs, int rowNum) throws SQLException {

        Author author=new Author();
        author.setAuthorId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostalCode(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));

        return author;
    }

    @Override
    @Transactional // whatever changes this method make in the Data base it will be treated as one for this annotation
    public Author addAuthor(Author author) {
        //don't need to add the id here because it will be generated by DB
        // the sequence should be matched with the Table
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirstName(),author.getLastName(),
                author.getStreet(),author.getCity(),author.getState(),
                author.getPostalCode(), author.getPhone(), author.getEmail());

        // grabbing the last inserted id from data base & pass it to a declare int id
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        author.setAuthorId(id);

        return author;
    }

    @Override
    public Author getAuthor(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this author_id, return null
            return null;
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL, this::mapRowToAuthor);
    }

    @Override
    public void updateAuthor(Author author) {
        // for the update we are passing all property values and lastly the ID
        // ID IS NEEDED
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirstName(),author.getLastName(),
                author.getStreet(),author.getCity(),author.getState(),
                author.getPostalCode(), author.getPhone(), author.getEmail(),author.getAuthorId());
    }

    @Override
    public void deleteAuthor(int id) {
        jdbcTemplate.update(DELETE_AUTHOR, id);

    }
}
