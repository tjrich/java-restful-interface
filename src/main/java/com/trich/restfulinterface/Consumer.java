package com.trich.restfulinterface;

import java.net.*;
import java.io.*;

public class Consumer {

    public static String getData(String apiEndpoint) throws Exception {
        StringBuilder sb = new StringBuilder();
        String[] list;
        URL query = new URL(apiEndpoint);
        HttpURLConnection conn = (HttpURLConnection) query.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        for (String line; (line = reader.readLine()) != null;) {
            sb.append(line);
        }
        list = sb.toString().split(",");
        list[0] = list[0].replace("[", " ");
        list[list.length - 1] = list[list.length - 1].replace("]", "");
        for (String s : list) {
            System.out.println(s);
        }
        return "";

    }

    public static void main(String[] args) throws Exception {
        System.out.println(getData("http://localhost:8080/api/dirlist?path=/"));
    }

}
