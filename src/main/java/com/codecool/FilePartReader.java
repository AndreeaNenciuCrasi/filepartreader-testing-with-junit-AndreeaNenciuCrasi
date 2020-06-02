package com.codecool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
    }

    public void setup (String filePath, int fromLine, int toLine){

        if((toLine < fromLine) || (fromLine < 1)) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;}
    }

    public String read (String filePath) //throws IOException
     {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        }catch (IOException e){

        }
        return data;
    }

    public String readLines (int fromLine, int toLine){
        return "test";
    }

}
