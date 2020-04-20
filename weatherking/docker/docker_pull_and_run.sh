#!/bin/bash

DOCKER_REPOSITORY=$1
DOCKER_IMAGE_NAME=$2
SPRING_PROFILE=$3
MYSQL_ROOT_PASSWORD=$4

sed -i 's/DOCKER_REPOSITORY=/DOCKER_REPOSITORY=${DOCKER_REPOSITORY}/g' docker-compose.env
sed -i 's/DOCKER_IMAGE_NAME=/DOCKER_IMAGE_NAME=${DOCKER_IMAGE_NAME}/g' docker-compose.env
sed -i 's/SPRING_PROFILE=/SPRING_PROFILE=${SPRING_PROFILE}/g' docker-compose.env
sed -i 's/MYSQL_ROOT_PASSWORD=/MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}/g' docker-compose.env

#docker-compose -f docker-compose.yml pull spring_app
docker-compose up -d