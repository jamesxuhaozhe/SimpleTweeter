#!/bin/bash

clear

echo 'Building project'

./gradlew clean build

echo 'Kill all DynamoDBLocal instances'

fuser -k 8000/tcp

echo 'Start DynamoDBLocal...'

java -Djava.library.path=./DynamoDBLocal/DynamoDBLocal_lib -jar ./DynamoDBLocal/DynamoDBLocal.jar -sharedDb -inMemory &

echo 'Boot your Spring application'

java -jar build/libs/ZeusService-0.0.1-SNAPSHOT.jar

