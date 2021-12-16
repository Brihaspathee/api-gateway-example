#!/bin/bash
echo "Hello I am inside the main script"
mvn clean package
cd service-discovery
source docker-build.sh
cd ..
cd api-gateway
source docker-build.sh
cd ..
cd department-service
source docker-build.sh
cd ..
cd student-service
source docker-build.sh
cd ..