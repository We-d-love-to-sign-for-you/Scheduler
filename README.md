# Description
Takes a request such as 
```json
{
    "skillName" : "TRANSLATION",
    "skillLevel" : "BASIC"
}
````
and returns an available interperter with required skill and skill level:
```json
{
  "id": "40911aaa-a6cd-4331-854e-0edf4ca53124",
  "available": false,
  "email": "test@example.com",
  "skills": [
    {
      "name": "TRANSLATION",
      "level": "FLUENT"
    }
  ],
  "videoLink": "https://meet.jit.si/687b1e03-6a12-4c06-881d-5d6158769111"
}
````

# Build and Deploy
- Build with `mvn clean package`
- Upload .jar from target directory to AWS
- Choose either Java 8 or Java 11 as runtime
- Set handler to `org.wedlovetosignforyou.ScheduleRequestHandler::handleRequest`

# Useful Links
- [AWS Lambda Developer Guide](https://docs.aws.amazon.com/de_de/lambda/latest/dg/welcome.html)
- [DynamoDB Developer Guide](https://docs.aws.amazon.com/de_de/amazondynamodb/latest/developerguide/Introduction.html)