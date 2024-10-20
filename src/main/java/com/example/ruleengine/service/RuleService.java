package com.example.ruleengine.service;

import com.example.ruleengine.model.Rule;
import com.example.ruleengine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    // Standard predefined rules
    private final String[] standardRules = {
        "age >= 18 && income >= 20000 && experience > 2",
        "department == 'Sales' || department == 'HR'",
        "experience > 5 || income > 50000"
    };

    public Rule saveRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    public void deleteRule(String id) {
        ruleRepository.deleteById(id);
    }

    public boolean evaluateEligibility(String ruleExpression, int age, int income, String department, int experience) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            String expression = ruleExpression
                    .replace("age", String.valueOf(age))
                    .replace("income", String.valueOf(income))
                    .replace("department", "\"" + department + "\"")
                    .replace("experience", String.valueOf(experience));

            return (boolean) engine.eval(expression);
        } catch (ScriptException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean evaluateWithStandardRules(int age, int income, String department, int experience) {
        List<Rule> customRules = getAllRules();
        for (Rule rule : customRules) {
            if (evaluateEligibility(rule.getRuleExpression(), age, income, department, experience)) {
                return true;
            }
        }

        for (String standardRule : standardRules) {
            if (evaluateEligibility(standardRule, age, income, department, experience)) {
                return true;
            }
        }

        return false;
    }
}
