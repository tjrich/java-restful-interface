package com.trich.restfulinterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulInterface {

    /* Debugging */
    @GetMapping("/status")
    public String test() {
        return "Status: OK";
    }

    // Set endpoint
    @GetMapping("/api/dirlist")
    @ResponseBody // Dynamic API path parameter
    public String directoryListing(@RequestParam(defaultValue = "/") String path) {

        File fileName = new File(path);
        File[] fileList = fileName.listFiles();
        List<String> filesArrStr = new ArrayList<>();

        // Formatting to print out 'Last modified date' in readable format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

        for (File file : fileList) {

            filesArrStr.add(
                    file.getPath() +
                            " Attributes:" +
                            " Read: " + file.canRead() +
                            " Write: " + file.canWrite() +
                            " Directory: " + file.isDirectory() +
                            " Last Modified: " + sdf.format(file.lastModified()) +
                            " Is Hidden: " + file.isHidden() +
                            " Size: " + file.length() + " bytes");
        }

        // return fileList.toString();
        return filesArrStr.toString();
    }
}
