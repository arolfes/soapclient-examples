#!/bin/bash

cd micronaut-soapclient
./gradlew clean wsdl2java build distTar

export JAVA_OPTS="-XX:MaxMetaspaceSize=64m -XX:+HeapDumpOnOutOfMemoryError -XX:+ExitOnOutOfMemoryError -Xms128m -Xmx128m -Dfile.encoding=UTF-8 -XX:+UseG1GC"

tar -C build/distributions -xvf build/distributions/micronaut-soapclient-1.0.0-SNAPSHOT.tar
echo "start micronaut soapclient example"
build/distributions/micronaut-soapclient-1.0.0-SNAPSHOT/bin/micronaut-soapclient

