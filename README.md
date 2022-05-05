# Entersekt Technical Assessment

### What You Need
- Java 11+
- Gradle 4+
- Spring Boot 2.6.7+
## Installation
### Clone This Repository
```
git clone https://github.com/tjrich/entersekt-assessment.git
```
```cd``` into the directory of the repository.

Run the following command
```bash
~$ gradle build
```
## Docker Guide
TODO
### Build Docker Image
To build the Docker image, run the following command
```bash
docker build -t <tag> .
```
Example
```bash
docker build -t restful-interface .
```
### Run in Docker Container
Once the build process has completed, run the following command
```bash
docker run -p 8080:8080 <tag>
```
Example
```bash
docker run -p 8080:8080 restful-interface
```
## Run Natively
### Linux
``` bash
~$ gradle bootRun
```
### Windows
``` cmd
> gradle bootRun
```

## Consuming the REST Service
- First make sure that the RESTful interface is running.
Contained in this repo is a class named ```Consumer.java```
```cd``` into the directory that contains ```Consumer.java```  
Example
```bash
~$ cd /src/main/java/com/trich/restfulinterface
```  
Once inside the directory of ```Consumer.java```, run the following command
```bash
~$ java Consumer.java http://localhost:8080/api/dirlist?path=/
```

