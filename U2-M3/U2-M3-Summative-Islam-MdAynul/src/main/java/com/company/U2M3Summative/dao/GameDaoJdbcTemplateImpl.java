package com.company.U2M3Summative.dao;

import com.company.U2M3Summative.model.Game;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {

    //prepare statement

    //add game
    private static final String INSERT_GAME_SQL=
            "insert into game (title, esrb_rating, description, price, studio, quantity) values (?, ?, ?, ?, ?, ?)";

    //get game
    private static final String SELECT_GAME_SQL=
            "select * from game where game_id = ?";

    //get all games
    private static final String SELECT_ALL_GAMES_SQL=
            "select * from game";

    //update game
    private static final String UPDATE_GAME_SQL=
            "update game set title =?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? where game_id = ?";

    //delete game
    private static final String DELETE_GAME_SQL=
            "delete from game where game_id = ?";

    //get game by studio
    private static final String SELECT_GAMES_BY_STUDIO_SQL=
            "select * from game where studio = ?";

    //get game by ESRB Rating
    private static final String SELECT_GAMES_BY_ESRB_RATING_SQL=
            "select * from game where esrb_rating= ?";

    //get game by Title
    private static final String SELECT_GAMES_BY_TITLE_SQL=
            "select * from game where title= ?";

    private JdbcTemplate jdbcTemplate; //injecting Jdbc template to interact with DB

    //constructor for jdbc
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Mapping between the row and the object to the Database Table
    private Game mapToRowToGame (ResultSet rs, int rowNum) throws SQLException{
         Game game =new Game();
         game.setGameId(rs.getInt("game_id"));
         game.setTitle(rs.getString("title"));
         game.setEsrbRating(rs.getString("esrb_rating"));
         game.setDescription(rs.getString("description"));
         game.setPrice(rs.getBigDecimal("price"));
         game.setStudio(rs.getString("studio"));
         game.setQuantity(rs.getInt("quantity"));

         return game;
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        //No need to add id; it's auto generated
        jdbcTemplate.update(INSERT_GAME_SQL,
                            game.getTitle(),game.getEsrbRating(),
                            game.getDescription(),game.getPrice(),
                            game.getStudio(),game.getQuantity());

        //grabbing the last inserted id from the DB
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",Integer.class);
        game.setGameId(id); //setting the id as game Id
        return game;
    }

    @Override
    public Game getGame(int gameId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL,this::mapToRowToGame,gameId);
        }catch (EmptyResultDataAccessException e){
            //if there is no match return null
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL,this::mapToRowToGame);
    }

    @Override
    public void updateGame(Game game) {
        //passing all the property of game lastly the Id
        jdbcTemplate.update(UPDATE_GAME_SQL,game.getTitle(),game.getEsrbRating(),
                                            game.getDescription(),game.getPrice(),
                                            game.getStudio(),game.getQuantity(),
                                            game.getGameId());

    }

    @Override
    public void deleteGame(int gameId) {
        jdbcTemplate.update(DELETE_GAME_SQL, gameId);

    }

    @Override
    public List<Game> getGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAMES_BY_STUDIO_SQL, this::mapToRowToGame, studio);
    }

    @Override
    public List<Game> getGamesByESRBRatings(String esrbRating) {
        return jdbcTemplate.query(SELECT_GAMES_BY_ESRB_RATING_SQL,this::mapToRowToGame, esrbRating);
    }

    @Override
    public List<Game> getGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAMES_BY_TITLE_SQL,this::mapToRowToGame, title);
    }
}
