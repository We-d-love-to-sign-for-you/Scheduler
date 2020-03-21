package org.wedlovetosignforyou;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "InterpreterTable")
public class Interpreter {
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute
    private boolean available;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private List<Skill> skills;
}
