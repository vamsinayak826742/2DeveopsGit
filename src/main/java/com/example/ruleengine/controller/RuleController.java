package com.example.ruleengine.controller;
import java.util.HashMap;
import com.example.ruleengine.model.Rule;
import com.example.ruleengine.repository.RuleRepository;
import com.example.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rules")
@CrossOrigin(origins = "*")
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private RuleService ruleService;

    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rule> updateRule(@PathVariable String id, @RequestBody Rule updatedRule) {
        Optional<Rule> ruleOptional = ruleRepository.findById(id);

        if (!ruleOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Rule existingRule = ruleOptional.get();
        existingRule.setRuleName(updatedRule.getRuleName());
        existingRule.setRuleExpression(updatedRule.getRuleExpression());

        Rule savedRule = ruleRepository.save(existingRule);
        return ResponseEntity.ok(savedRule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable String id) {
        if (!ruleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ruleRepository.deleteById(id);
        return ResponseEntity.ok("Rule deleted successfully");
    }

    @PostMapping("/evaluate")
    public ResponseEntity<Map<String, Boolean>> evaluateEligibility(@RequestBody Map<String, Object> userInput) {
        int age = (int) userInput.get("age");
        int income = (int) userInput.get("income");
        String department = (String) userInput.get("department");
        int experience = (int) userInput.get("experience");

        boolean eligible = ruleService.evaluateWithStandardRules(age, income, department, experience);
        
        // Creating a map in a way compatible with Java 7
        Map<String, Boolean> response = new HashMap<>();
        response.put("eligible", eligible);
        
        return ResponseEntity.ok(response);
    }

}
