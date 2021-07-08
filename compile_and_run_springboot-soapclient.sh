#!/bin/bash

cd springboot-soapclient
./gradlew clean build

JAVA_OPTS="-XX:MaxMetaspaceSize=128m -XX:+HeapDumpOnOutOfMemoryError -XX:+ExitOnOutOfMemoryError -Xms256m -Xmx256m -Dfile.encoding=UTF-8 -XX:+UseG1GC"

echo "start springboot soapclient example"
java $JAVA_OPTS -jar build/libs/springboot-soapclient-1.0.0-SNAPSHOT.jar
