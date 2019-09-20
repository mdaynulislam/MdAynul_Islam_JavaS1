package com.trilogyed.glossaryservice.model;

import java.util.Objects;

public class Definition {

    private Integer id;
    private String term;
    private String definition;

    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    //Equal and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return id.equals(that.id) &&
                term.equals(that.term) &&
                definition.equals(that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, definition);
    }
}
