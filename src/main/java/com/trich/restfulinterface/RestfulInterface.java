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

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @GetMapping("/api/dirlist")
    @ResponseBody
    public String directoryListing(@RequestParam(defaultValue = "/") String path) {
        // String dirName = "/mnt/c/";

        File fileName = new File(path);// File(dirName);
        File[] fileList = fileName.listFiles();
        List<String> filesArrStr = new ArrayList<>();

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

        // return listStr.toString();
        return filesArrStr.toString();
    }
}
