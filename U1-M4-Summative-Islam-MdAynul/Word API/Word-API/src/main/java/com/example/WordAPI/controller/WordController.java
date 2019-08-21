package com.example.WordAPI.controller;


import com.example.WordAPI.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController  // let spring know about this class as a controller

public class WordController {

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Definition definition(){ // Definition class composition

        List<Definition> getDefinition=new ArrayList<>();  // ArrayList of Definition class

        //populating the ArrayList by creating object of getDefinition ArrayList

        getDefinition.add(new Definition("Social Equality","Is a state of affairs in which all people within a specific society have the same status in certain respects."));
        getDefinition.add(new Definition("Love","Love is when you choose to be at your best when the other person is not at their best. "));
        getDefinition.add(new Definition("Legacy","A gift by will especially of money or other personal property. "));
        getDefinition.add(new Definition("Liberty","The quality or state of being free. "));
        getDefinition.add(new Definition("Leadership","Capacity to lead and take everyone towards the goal who might fall behind. "));
        getDefinition.add(new Definition("Surreal","Marked by the intense irrational reality of a dream. "));
        getDefinition.add(new Definition("Happiness","A state of well-being and contentment through a pleasurable or satisfying experience. "));
        getDefinition.add(new Definition("Integrity","The quality of being honest and having strong moral principles; moral uprightness. "));
        getDefinition.add(new Definition("Imperialism","A policy of extending a country's power and influence through diplomacy or military force. "));
        getDefinition.add(new Definition("Metaphor","A figure of speech in which a word or phrase is applied to an object or action to which it is not literally applicable. "));

        Random random=new Random();
        int indexDefinition=random.nextInt(getDefinition.size()); // Random bound is the size of the getDefinition ArrayList
        return getDefinition.get(indexDefinition); // passing the random index in the parameter to get the values
    }
}
