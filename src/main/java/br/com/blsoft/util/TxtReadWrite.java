package br.com.blsoft.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtReadWrite {

    private String filePath;

    public TxtReadWrite(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readFile() throws IOException {
        List<String> linhas = new ArrayList<>();
        File file = new File(this.filePath);
        if (file.createNewFile()){
            System.out.println("Arquivo criado em " + this.filePath);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                linhas.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return linhas;
    }
}
