package com.example.weatherking.util;

import com.example.weatherking.StaticBaseBean;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

public class FileUtil extends StaticBaseBean {

    public static String readFile(String path) throws IOException {
        var sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        while (true) {
            var l = br.readLine();
            if (l == null)
                break;
            sb.append(l).append("\n");
        }
        br.close();
        return sb.toString();
    }

    public static String readFile(ClassPathResource path) throws IOException {
        URI uri = path.getURI();
        return readFile(uri.getPath());
    }
}
