package com.company.MdAynulIslamU1Capstone.controller;


import com.company.MdAynulIslamU1Capstone.exception.NotFoundException;
import com.company.MdAynulIslamU1Capstone.service.GameInventoryService;
import com.company.MdAynulIslamU1Capstone.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TShirtViewController {

    @Autowired
    GameInventoryService service;

    /******************************TShirtViewModel controller***********************************/

    //add TShirt
    @RequestMapping(value = "/tShirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirtViewModel addTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel){
        service.saveTShirt(tShirtViewModel);
        return  tShirtViewModel;
    }

    //find tShirt
    @RequestMapping(value = "/tShirt/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable (name = "id") int id){
        TShirtViewModel tShirtViewModel =service.findTShirt(id);
        if(tShirtViewModel == null)
            throw new NoSuchElementException("TShirt could not be retrieve for this id "+id);
        return tShirtViewModel;
    }

    //find All TShirt
    @RequestMapping(value = "/tShirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts(){
        return service.findAllTShirts();
    }

    //update TShirt
    @RequestMapping(value = "/tShirt/{id}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTShirt(@PathVariable (name = "id") int tShirtId, @Valid @RequestBody TShirtViewModel tShirtViewModel ){
        if(tShirtViewModel.gettShirtId()== 0)
            tShirtViewModel.settShirtId(tShirtId);
        if(tShirtId != tShirtViewModel.gettShirtId()){
            throw new IllegalArgumentException("TShirt Id on the path must match in the TShirt object");
        }
        service.updateTShirt(tShirtViewModel);
    }

    //delete TShirt

    @RequestMapping(value = "/tShirt/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTShirt(@PathVariable(name = "id") int id){
        TShirtViewModel tShirtViewModel =service.findTShirt(id);

        if(tShirtViewModel == null){
            throw new NotFoundException("No TShirt available with this Id. ");
        }else {
            service.removeTShirt(id);
        }
    }

    //get TShirt by Color

    @RequestMapping(value = "/tShirt/color/{color}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable (name = "color") String color)throws IllegalArgumentException{
        List<TShirtViewModel> tShirtViewModelList = service.findTShirtsByColor(color);
        if(tShirtViewModelList == null) throw new NotFoundException("This color doesn't have any TShirt");
        return tShirtViewModelList;
    }

    //get TShirt by size
    @RequestMapping(value = "/tShirt/size/{size}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable (name = "size") String size)throws IllegalArgumentException{
        List<TShirtViewModel> tShirtViewModelList = service.findTShirtsBySize(size);
        if(tShirtViewModelList == null) throw new NotFoundException("This size doesn't have any TShirt");
        return tShirtViewModelList;
    }

    /***********************************   End of TShirtViewModel controller***********************************/



}
