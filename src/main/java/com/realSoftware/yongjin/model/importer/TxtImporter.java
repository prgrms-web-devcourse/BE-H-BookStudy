package com.realSoftware.yongjin.model.importer;

import java.io.*;

public class TxtImporter implements Importer {
    @Override
    public String importResource(String path) {
        File file = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
