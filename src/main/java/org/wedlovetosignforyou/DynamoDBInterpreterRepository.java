package org.wedlovetosignforyou;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import java.util.List;

public class DynamoDBInterpreterRepository implements InterpreterRepository {

    private DynamoDBMapper dynamoDBMapper;

    public DynamoDBInterpreterRepository() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    @Override
    public List<Interpreter> findInterpretersBySkillName(String skillName) {
        return dynamoDBMapper.query(Interpreter.class, new DynamoDBQueryExpression<>());
    }

}
