package com.example.Magic8Ball.controller;


import com.example.Magic8Ball.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class Magic8BallController {


    @RequestMapping(value = "/magic",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer getAnswer(@RequestBody Answer question){


        // string of answer
        String [] answer={"Yes, of course", "Without a doubt, Yes", "You can count on it",
                            "Ask me Later", "I'm not sure", "I will tell you after my nap",
                            "I don't think so", "Pretty sure", "Doubtful"};


        Random random=new Random();
        int answerIndex=random.nextInt(answer.length);
        // getting the question from request body but the answer is random
        return new Answer(question.getQuestion(),answer[answerIndex]);
    }
}
