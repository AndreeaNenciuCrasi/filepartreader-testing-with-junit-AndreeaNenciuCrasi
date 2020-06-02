package com.codecool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
    }

    public int getFromLine() {
        return fromLine;
    }

    public int getToLine() {
        return toLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int setFromLine(int fromLine) {
        if (fromLine <= toLine) {
            return this.fromLine = fromLine;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public int setToLine(int toLine) {
        if( toLine >= fromLine){
        return this.toLine = toLine;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {

            if ((toLine < fromLine) || (fromLine < 1)) {
                throw new IllegalArgumentException();
            }
                this.filePath = "src/main/resources/text_file.txt";
                this.fromLine = fromLine;
                this.toLine = toLine;
    }

    public String read() {
//        String data = "";
//        try {
//            data = new String(Files.readAllBytes(Paths.get(filePath)));
//        }catch (IOException e){}
//        return data;

        File file = new File(filePath);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }

        } catch (IOException e) {
        }
        return fileContents.toString();
    }

    public String readLines() throws IndexOutOfBoundsException {
        List<String> listOfLines;
        listOfLines = Arrays.asList(this.read().split("\\r?\\n"));
        int numberOfLines = listOfLines.size();
        StringBuilder stringResult = new StringBuilder();

        if (fromLine == 1 && toLine == 1) {
            stringResult.append(listOfLines.get(0));
        } else if (fromLine > toLine) {
            System.out.println("First argument must be smaller or equal to second argument.");
            throw new IndexOutOfBoundsException();
        } else if (toLine > numberOfLines) {
            for (int i = fromLine - 1; i < numberOfLines; i++) {
                stringResult.append(listOfLines.get(i));
            }
        } else {
            for (int i = fromLine - 1; i < toLine; i++) {
                stringResult.append(listOfLines.get(i));
            }
        }
        return stringResult.toString();

    }

}
