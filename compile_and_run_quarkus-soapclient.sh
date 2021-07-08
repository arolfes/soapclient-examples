#!/bin/bash

cd quarkus-soapclient
./gradlew clean wsdl2java quarkusBuild -Dquarkus.package.type=uber-jar 

JAVA_OPTS="-XX:MaxMetaspaceSize=64m -XX:+HeapDumpOnOutOfMemoryError -XX:+ExitOnOutOfMemoryError -Xms64m -Xmx64m -Dfile.encoding=UTF-8 -XX:+UseG1GC"

echo "start quarkus soapclient example"
java $JAVA_OPTS -jar build/quarkus-soapclient-1.0.0-SNAPSHOT-runner.jar
