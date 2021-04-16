## 构建服务
# https://hub.docker.com/_/openjdk?tab=tags&page=4&name=alpine
#FROM openjdk:8u212-jdk-alpine3.9
FROM zh-registry.geostar.com.cn/geopanel/openjdk-12-jdk-alpine3.9:20210111
LABEL maintainer="jianghanghang@geostar.com.cn"

ARG VERSION=v0.0.1
ARG JAR_FILE=springboot-demo1-0.0.1-SNAPSHOT.jar

LABEL VERSION=$VERSION
LABEL JAR_FILE=$JAR_FILE

ADD $JAR_FILE /app/app.jar
WORKDIR /app

# 解压配置文件到指定目录
#RUN unzip -j /app/gpl-datacollection-mgr.jar BOOT-INF/classes/application.properties -d /app/conf/

#COPY docker-entrypoint.sh /
#RUN chmod +x /docker-entrypoint.sh
#RUN yum update && yum install -y update-ca-certificates \
#    && ca-certificates-java -f \
#    &&

EXPOSE 8080

ENTRYPOINT ["java","-jar", "/app/app.jar"]