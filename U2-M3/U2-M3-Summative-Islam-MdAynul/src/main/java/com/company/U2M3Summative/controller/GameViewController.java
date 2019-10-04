package com.company.U2M3Summative.controller;
import com.company.U2M3Summative.exception.NotFoundException;
import com.company.U2M3Summative.service.GameInventoryService;
import com.company.U2M3Summative.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class GameViewController {

    @Autowired
    GameInventoryService service;

    /*******************************************GameViewModel controller***********************************/

    //add game
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody @Valid GameViewModel gameViewModel){
        service.saveGame(gameViewModel);
        return gameViewModel;
    }

    //find game
    @RequestMapping(value = "/game/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public GameViewModel getGame(@PathVariable (name = "id") int id){
        GameViewModel gameViewModel =service.findGame(id);
        if(gameViewModel == null)
            throw new NoSuchElementException("Game could not be retrieve for this id "+id);
        return gameViewModel;
    }

    //find all games

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getAllGames(){
        return service.findAllGames();
    }

    //update game

    @RequestMapping(value = "/game/{id}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@PathVariable (name = "id") int gameId, @Valid @RequestBody GameViewModel gameViewModel ){
        if(gameViewModel.getGameId()== 0)
            gameViewModel.setGameId(gameId);
        if(gameId != gameViewModel.getGameId()){
            throw new IllegalArgumentException("Game Id on the path must match in the Game object");
        }
        service.updateGame(gameViewModel);
    }

    //delete game

    @RequestMapping(value = "/game/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable(name = "id") int id){
        GameViewModel gameViewModel =service.findGame(id);

        if(gameViewModel == null){
            throw new NotFoundException("No game available with this Id. ");
        }else {
            service.removeGame(id);
        }
    }

    //get game by studio

    @RequestMapping(value = "/game/studio/{studio}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable (name = "studio") String studio)throws IllegalArgumentException{
        List<GameViewModel> gameViewModelList = service.findGamesByStudio(studio);
        if(gameViewModelList == null) throw new NotFoundException("This studio doesn't have any game");
        return gameViewModelList;
    }

    //get game by esrb_rating

    @RequestMapping(value = "/game/esrb_rating/{esrb_rating}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByESRBRatings(@PathVariable (name = "esrb_rating") String esrb_rating)throws IllegalArgumentException{
        List<GameViewModel> gameViewModelList = service.findGamesByESRBRatings(esrb_rating);
        if(gameViewModelList == null) throw new NotFoundException("This esrb_rating doesn't have any game");
        return gameViewModelList;
    }

    //get game by title

    @RequestMapping(value = "/game/title/{title}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable (name = "title") String title)throws IllegalArgumentException{
        List<GameViewModel> gameViewModelList = service.findGamesByTitle(title);
        if(gameViewModelList == null) throw new NotFoundException("This title doesn't have any game");
        return gameViewModelList;
    }

}
