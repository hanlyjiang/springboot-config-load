# docker build --no-cache -t event-tracking-mgr:20201123 .
# docker buildx build --platform=linux/arm64,linux/amd64 -t registry.cn-hangzhou.aliyuncs.com/geopanel/event-tracking-mgr:v0.0.1 ./ --push
# docker buildx build --platform=linux/arm64,linux/amd64 --build-arg VERSION=v0.0.1 --build-arg TOKEN_JAR_FILE=DataCollection-0.0.1-SNAPSHOT.war -t registry.cn-hangzhou.aliyuncs.com/hasura/event-tracking-mgr:v0.0.1 ./ --push

TAG=$(date "+%Y%m%d")
NAME=gpl-datacollection
VERSION=0.1.0-$TAG
JAR_FILE=DataCollection-0.1.0-SNAPSHOT.jar


cp ../build/libs/springboot-demo1-0.0.1-SNAPSHOT.jar ./
