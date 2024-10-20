package com.ruleengine.service;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.ruleengine.model.UserInput; // Import the UserInput class
import com.ruleengine.model.Rule;
import com.ruleengine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @PostConstruct
    public void init() {
        // Check if the rules repository is empty
        if (ruleRepository.count() == 0) {
            createDefaultRules();
        }
    }

    private void createDefaultRules() {
        List<Rule> defaultRules = new ArrayList<>();

        // Create standard rules
        defaultRules.add(new Rule("Rule 1", "age >= 18"));
        defaultRules.add(new Rule("Rule 2", "salary >= 30000"));
        defaultRules.add(new Rule("Rule 3", "experience <= 2"));

        // Save default rules to the repository
        ruleRepository.saveAll(defaultRules);
    }

    // Create or update a rule
    public Rule saveRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    // Get all rules
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // Get a rule by ID
    public Optional<Rule> getRuleById(String id) {
        return ruleRepository.findById(id);
    }

    // Delete a rule by ID
    public void deleteRule(String id) {
        ruleRepository.deleteById(id);
    }

    // Evaluate user data against stored rules
    public boolean evaluateRules(UserInput userInput) {
        List<Rule> rules = getAllRules();
        for (Rule rule : rules) {
            if (evaluateExpression(rule.getExpression(), userInput)) {
                return true; // User is eligible
            }
        }
        return false; // User is not eligible
    }

    // Method to evaluate expressions based on user input
    private boolean evaluateExpression(String expression, UserInput userInput) {
        // Replace variables with actual values in the expression
        expression = expression.replace("age", String.valueOf(userInput.getAge()))
                               .replace("department", "'" + userInput.getDepartment() + "'")
                               .replace("salary", String.valueOf(userInput.getSalary()))
                               .replace("experience", String.valueOf(userInput.getExperience()));

        try {
            // Evaluate the expression using JavaScript engine
            return (boolean) new ScriptEngineManager().getEngineByName("JavaScript").eval(expression);
        } catch (ScriptException e) {
            e.printStackTrace();
            return false; // Handle evaluation error
        }
    }
}
