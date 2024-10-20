package com.ruleengine.controller;

import com.ruleengine.model.Rule;
import com.ruleengine.model.UserInput;
import com.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    // Endpoint to create a new rule
    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        Rule savedRule = ruleService.saveRule(rule);
        return ResponseEntity.ok(savedRule);
    }

    // Endpoint to get all rules
    @GetMapping
    public ResponseEntity<List<Rule>> getAllRules() {
        List<Rule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    // Endpoint to evaluate user input against the rules
    @PostMapping("/evaluate")
    public ResponseEntity<String> evaluateUserInput(@RequestBody UserInput userInput) {
        boolean isEligible = ruleService.evaluateRules(userInput);
        return ResponseEntity.ok(isEligible ? "User is eligible." : "User is not eligible.");
    }

    // Endpoint to delete a rule by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable String id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
