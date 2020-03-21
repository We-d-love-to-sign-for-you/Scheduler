package org.wedlovetosignforyou;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamoDBInterpreterRepository implements InterpreterRepository {

    private static final List<String> SKILL_LEVELS = Arrays.asList("BASIC", "FLUENT", "PROFESSIONAL", "NATIVE");

    private DynamoDBMapper dynamoDBMapper;

    public DynamoDBInterpreterRepository() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    @Override
    public List<Interpreter> findAvailableInterpretersBySkillNameAndMinLevel(String skillName, String minSkillLevel) {
        List<Interpreter> interpreters = new ArrayList<>();
        for (Interpreter interpreter : findAllInterpreters()) {
            for (Skill skill : interpreter.getSkills()) {
                if (interpreter.isAvailable() && skill.getName().equals(skillName) &&
                        isEqualOrAbove(skill.getLevel(), minSkillLevel)) {
                    interpreters.add(interpreter);
                }
            }
        }
        return interpreters;
    }

    @Override
    public void saveInterpreter(Interpreter interpreter) {
        dynamoDBMapper.save(interpreter);
    }

    private PaginatedScanList<Interpreter> findAllInterpreters() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Interpreter.class, scanExpression);
    }

    private boolean isEqualOrAbove(String level, String minSkillLevel) {
        return SKILL_LEVELS.indexOf(minSkillLevel) <= SKILL_LEVELS.indexOf(level);
    }

}
