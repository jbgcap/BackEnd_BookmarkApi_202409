FROM openjdk:17
VOLUME /tmp
COPY target/springboot-nextjs-backend.jar springboot-nextjs-backend.jar
ENTRYPOINT ["java","-jar","/springboot-nextjs-backend.jar","--spring.profiles.active=prod"]