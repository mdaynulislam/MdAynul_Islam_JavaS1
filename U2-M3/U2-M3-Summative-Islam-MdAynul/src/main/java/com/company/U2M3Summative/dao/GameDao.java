package com.company.U2M3Summative.dao;

import com.company.U2M3Summative.model.Game;

import java.util.List;

public interface GameDao {
    //CRUD

    Game addGame(Game game);

    Game getGame(int gameId);

    List<Game> getAllGames();

    void updateGame(Game game);

    void deleteGame(int gameId);

    //get Games by by studio

    List<Game> getGamesByStudio(String studio);

    //get games by ESRB Ratings
    List<Game> getGamesByESRBRatings(String esrbRating);

    //get games by title
    List<Game> getGamesByTitle(String title);
}
