package com.trilogyed.glossaryservice.controller;

import com.trilogyed.glossaryservice.service.DefinitionService;
import com.trilogyed.glossaryservice.util.feign.GlossaryClient;
import com.trilogyed.glossaryservice.model.Definition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class GlossaryController {

@Autowired
private final DefinitionService service;


    public GlossaryController(DefinitionService service) {
        this.service = service;
    }

    @RequestMapping(value = "/glossary/term/{term}", method = RequestMethod.GET)
    public List<Definition> getDefinitionsForTerm(@PathVariable String term){
        try {
            return service.findDefinitionsForTerm(term);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    @RequestMapping(value = "/glossary", method = RequestMethod.POST)
    public Definition addDefinition(@RequestBody @Valid Definition definition){
        return service.saveDefinition(definition);
    }
}
