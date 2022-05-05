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

    @GetMapping("/api/dirlisting")
    @ResponseBody
    public String directoryListing(@RequestParam(defaultValue = "/") String path) {
        // String dirName = "/mnt/c/Users/timot";
        // String dirName = path;

        File fileName = new File(path);
        File[] fileList = fileName.listFiles();
        List<String> filesArrStr = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

        for (File file : fileList) {
            filesArrStr.add(
                    "File: " + file.getPath() +
                            "\nAttributes:" +
                            " \nRead: " + file.canRead() +
                            " \nWrite: " + file.canWrite() +
                            " \nDirectory: " + file.isDirectory() +
                            " \nLast Modified: " + sdf.format(file.lastModified()) +
                            " \nIs Hidden: " + file.isHidden() +
                            " \nSize: " + file.length() + " bytes");
        }

        // return listStr.toString();
        return filesArrStr.toString();
    }
}
