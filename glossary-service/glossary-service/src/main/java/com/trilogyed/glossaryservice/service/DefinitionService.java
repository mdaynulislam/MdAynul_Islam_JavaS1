package com.trilogyed.glossaryservice.service;

import com.trilogyed.glossaryservice.model.Definition;
import com.trilogyed.glossaryservice.util.feign.GlossaryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefinitionService {

    private GlossaryClient glossaryClient;

    @Autowired
    public DefinitionService(GlossaryClient glossaryClient) {
        this.glossaryClient = glossaryClient;
    }

    public List<Definition> findDefinitionsForTerm(String term){
        List<Definition> definitions = glossaryClient.getDefinitionsForTerm(term);
        return definitions;
    }
    public Definition saveDefinition(Definition definition){
        Definition def = new Definition();
        def.setTerm(definition.getTerm());
        if(definition.getDefinition().toLowerCase().contains(" darn ") ||
                definition.getDefinition().toLowerCase().contains(" heck ") ||
                definition.getDefinition().toLowerCase().contains(" drat ") ||
                definition.getDefinition().toLowerCase().contains(" jerk ") ||
                definition.getDefinition().toLowerCase().contains(" butt ")){
            throw new IllegalArgumentException(" The word doesn't seem to decent to be added, would you change it!");
        }else {
            def.setDefinition(definition.getDefinition());
        }
        return def;
    }

}
