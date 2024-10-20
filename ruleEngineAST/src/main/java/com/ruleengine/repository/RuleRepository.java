package com.ruleengine.repository;

import com.ruleengine.model.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends MongoRepository<Rule, String> {
    // Custom query methods can be added here if needed
}
