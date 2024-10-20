package com.ruleengine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class Rule {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String expression;

    // Constructors
    public Rule() {
    }

    public Rule(String name, String expression) { // Change ruleName to name
        this.name = name; // Update this line
        this.expression = expression;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
