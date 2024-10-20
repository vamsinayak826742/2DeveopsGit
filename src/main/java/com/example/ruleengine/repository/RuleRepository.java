package com.example.ruleengine.repository;

import com.example.ruleengine.model.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends MongoRepository<Rule, String> {
    // Custom MongoDB queries can be added here if needed
}
