package com.company.MdAynulIslamU1Capstone.daoTest;

import com.company.MdAynulIslamU1Capstone.dao.GameDao;
import com.company.MdAynulIslamU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoJdbcTemplateImplTest {
    @Autowired
    GameDao gameDao;

    @Before
    public void setUp()throws Exception{
        //deleting the Game in the Data Base
        List<Game> gameList = gameDao.getAllGames();
        for(Game gm: gameList){
            gameDao.deleteGame(gm.getGameId());
        }
    }

    @Test
    public void addGetDeleteGame(){
        // without the game id; it's PK
         Game game= new Game();

         game.setTitle("Resident Evil");
         game.setEsrbRating("M");
         game.setDescription("Action");
         game.setPrice(new BigDecimal("29.99"));
         game.setStudio("Evil");
         game.setQuantity(50);

         game=gameDao.addGame(game); // adding the game in the dao

         Game game1 = gameDao.getGame(game.getGameId()); // passing the same game into game1

        //compare
        assertEquals(game1,game);

        gameDao.deleteGame(game.getGameId()); // deleting the game
        game1=gameDao.getGame(game.getGameId()); // passing the deleted game into game1

        assertNull(game1);

    }

    @Test
    public void getAllGames(){
        //populating the first game

        Game game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding the first game to dao


        //populating the 2nd game
         game= new Game();

        game.setTitle("Resident Evil 2");
        game.setEsrbRating("M2");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        gameDao.addGame(game); // adding the 2nd game

        //passing all the game in a list

        List<Game> gameList= gameDao.getAllGames();
        //comparing the list which should have 2 games
        assertEquals(2,gameList.size());

    }

    @Test
    public void updateGame(){

        //populating the game

        Game game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding the first game

        //populating the same game with updated data
        game.setTitle("Resident Evil updated");
        game.setEsrbRating("M2");
        game.setDescription("Action reload");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        gameDao.updateGame(game); // updating the game

        Game game1=gameDao.getGame(game.getGameId()); // adding the updated game into game1

        assertEquals(game1,game);

    }

    @Test
    public void getGameByStudio(){

        //populating the game

        Game game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding the populated game into dao

        //adding the same game with same studio

         game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding 2nd game

        //passing the 2 games in a List

        List<Game> byStudio= gameDao.getGamesByStudio("Evil");
        assertEquals(2,byStudio.size()); // same studio has 2 games

        byStudio=gameDao.getGamesByStudio("Fake Studio"); // doesn't exist
        assertEquals(0,byStudio.size());

    }

    @Test
    public void getGamesByESRBRatings(){

        //populating the game

        Game game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding the populated game into dao

        //adding the same game with same studio

        game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding 2nd game

        //passing the 2 games in a List

        List<Game> byEsrbRatings= gameDao.getGamesByESRBRatings("M");
        assertEquals(2,byEsrbRatings.size()); // same esrbRating has 2 games

        byEsrbRatings=gameDao.getGamesByStudio("Fake Esrb Rating"); // doesn't exist
        assertEquals(0,byEsrbRatings.size());

    }

    @Test
    public void getGamesByTitle(){

        //populating the game

        Game game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding the populated game into dao

        //adding the same game with same studio

        game= new Game();

        game.setTitle("Resident Evil");
        game.setEsrbRating("M");
        game.setDescription("Action");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("Evil");
        game.setQuantity(50);

        game=gameDao.addGame(game); // adding 2nd game

        //passing the 2 games in a List

        List<Game> byTitle= gameDao.getGamesByTitle("Resident Evil");
        assertEquals(2,byTitle.size()); // same Title has 2 games

        byTitle=gameDao.getGamesByStudio("Fake Title"); // doesn't exist
        assertEquals(0,byTitle.size());

    }

}
