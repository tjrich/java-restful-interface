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
