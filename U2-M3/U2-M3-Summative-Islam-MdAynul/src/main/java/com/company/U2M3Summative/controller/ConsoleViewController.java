package com.company.U2M3Summative.controller;

import com.company.U2M3Summative.exception.NotFoundException;
import com.company.U2M3Summative.service.GameInventoryService;
import com.company.U2M3Summative.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ConsoleViewController {

    @Autowired
    GameInventoryService service;

    /******************************ConsoleViewModel controller***********************************/


    //add console

    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel addConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel){
        service.saveConsole(consoleViewModel);
        return consoleViewModel;
    }

    //find console

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable (name = "id") int id){
        ConsoleViewModel consoleViewModel = service.findConsole(id);
        if(consoleViewModel == null)
            throw new NoSuchElementException("Console could not be retrieve for this id "+id);
        return consoleViewModel;
    }

    // find all consoles

    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles(){

        return service.findAllConsoles();
    }

    //update Console
    @RequestMapping(value = "/console/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@PathVariable (name = "id") int consoleId, @Valid @RequestBody ConsoleViewModel consoleViewModel){
        if (consoleViewModel.getConsoleId()== 0)
            consoleViewModel.setConsoleId(consoleId);
        if(consoleId != consoleViewModel.getConsoleId()){
            throw new IllegalArgumentException("Console Id on the path must match in the Console object ");
        }
        service.updateConsole(consoleViewModel);
    }

    //delete console
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable (name = "id") int id){

        ConsoleViewModel consoleViewModel = service.findConsole(id);

        if(consoleViewModel == null) {
            throw new NotFoundException("No console available with this Id");
        }else {
            service.removeConsole(id);
        }
    }

    //get consoles by Manufacturer

    @RequestMapping(value = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable (name = "manufacturer") String manufacturer)throws IllegalArgumentException{
        List<ConsoleViewModel> consoleViewModelList = service.findConsoleByManufacturer(manufacturer);
        if(consoleViewModelList == null) throw new NotFoundException("This manufacturer doesn't have any game");
        return consoleViewModelList;
    }


}
