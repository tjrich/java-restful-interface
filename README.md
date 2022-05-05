# Java RESTful Interface

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

Wait for Gradle to initialise all required files. You should see directories
such as ```.gradle``` and ```bin``` once initialisation is complete.

Run the following command
```bash
~$ gradle build
```
## Docker Guide
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
First make sure that the RESTful interface is running.    
### Consumer class
Contained in this repo is a class named ```Consumer.java```  
```Consumer.java``` class makes use of a GET request supported by the built-in Java class ```HttpUrlConnection```.  
```java
package com.trich.restfulinterface;

import java.net.*;
import java.io.*;

public class Consumer {

    public static String getData(String apiEndpoint) throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] filesList; // String list to hold formatted results
        URL query = new URL(apiEndpoint);
        HttpURLConnection conn = (HttpURLConnection) query.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        for (String line; (line = reader.readLine()) != null;) {
            sb.append(line);
        }
        /* Cleanup directory listing results */

        // Splits results by comma delimiter
        filesList = sb.toString().split(",");

        // Removes square bracket in the beginning of results
        filesList[0] = filesList[0].replace("[", " ");

        // Removes sqaure bracket at the end of results
        filesList[filesList.length - 1] = filesList[filesList.length - 1].replace("]", "");

        // Individually print out file, path, attributes and size
        for (String s : filesList) {
            System.out.println(s);
        }
        return "";

    }

    public static void main(String[] args) throws Exception {
        // Obtain directory listing via a run argument
        System.out.println(getData(args[0]));
    }

}

```  
### Run the Consumer
```cd``` into the directory that contains ```Consumer.java```  

```bash
~$ cd /src/main/java/com/trich/restfulinterface
```  
Once inside the directory of ```Consumer.java```, run the following command
```bash
~$ java Consumer.java http://localhost:8080/api/dirlist?path="PATH"
```
Example - Linux
```bash
~$ java Consumer.java http://localhost:8080/api/dirlist?path=/
```
Example - Windows
```bash
~$ java Consumer.java http://localhost:8080/api/dirlist?path=C:\\
```

