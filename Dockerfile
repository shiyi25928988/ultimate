FROM eclipse/alpine_jdk8

WORKDIR /app

RUN mkdir -p /app/data
# 将本地的 Java 应用程序文件复制到容器中
COPY target/ultimate-1.0-SNAPSHOT.jar /app/my-app.jar

# 暴露应用程序端口
EXPOSE 8080

# 运行 Java 应用程序
CMD ["java", "-jar", "my-app.jar"]