# FROM openjdk:11
# ADD build/libs/*.jar dockerapp.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","dockerapp.jar"]

FROM openjdk:11
VOLUME = /tmp
ADD build/libs/*.jar dockerimage.jar
EXPOSE 8080
RUN bash -c 'touch /dockerimage.jar'
ENTRYPOINT ["java","-jar","dockerimage.jar"]