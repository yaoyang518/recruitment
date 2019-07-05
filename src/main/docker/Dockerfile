FROM openjdk:8-jre
VOLUME /tmp
ADD recruitment-0.0.1.jar app.jar
ENV PARAMS=""
ENTRYPOINT ["sh","-c","java -Dspring.profiles.active=$PARAMS -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -server -Xms2g -Xmx2g -Xss256k -XX:-TieredCompilation -XX:+UseStringDeduplication -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=20 -XX:ConcGCThreads=5 -XX:InitiatingHeapOccupancyPercent=70 -jar /app.jar"]
