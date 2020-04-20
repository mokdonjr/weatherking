DOCKER_REPOSITORY=$1
DOCKER_IMAGE_NAME=$2
SPRING_PROFILE=$3
MYSQL_ROOT_PASSWORD=$4

#docker-compose -f docker-compose.yml pull spring_app
docker-compose up -d