package com.example.QuoteAPI.controller;


import com.example.QuoteAPI.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController  // passing spring the information that this class will be a controller
public class QuoteController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote(){


        //ArrayList of Quote class
        List<Quote> quoteList=new ArrayList<>();

        //populating the arrayList
        quoteList.add(new Quote(" Oscar Wilde "," Be yourself; everyone else is already taken. "));
        quoteList.add(new Quote(" Mahatma Gandhi "," Be the change that you wish to see in the world. "));
        quoteList.add(new Quote(" Mark Twain "," If you tell the truth, you don't have to remember anything. "));
        quoteList.add(new Quote(" J.K. Rowling "," If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals. "));
        quoteList.add(new Quote(" Oscar Wilde "," To live is the rarest thing in the world. Most people exist, that is all. "));
        quoteList.add(new Quote(" Friedrich Nietzsche "," Without music, life would be a mistake. "));
        quoteList.add(new Quote(" Albert Einstein "," Strive not to be a success, but rather to be of value. "));
        quoteList.add(new Quote(" Kevin Kruse "," Life isn't about getting and having, it's about giving and being. "));
        quoteList.add(new Quote(" Napoleon Hill "," Whatever the mind of man can conceive and believe, it can achieve. "));
        quoteList.add(new Quote(" Marcus Tullius Cicero "," A room without books is like a body without a soul. "));


        Random random=new Random();
        int randomQuote=random.nextInt(quoteList.size()); // quoteList size is the bound for Random number.
        return quoteList.get(randomQuote);
    }
}
