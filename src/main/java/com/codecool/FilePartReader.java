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

    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        try {
            if ((toLine < fromLine) || (fromLine < 1)) {
                this.filePath = filePath;
                this.fromLine = fromLine;
                this.toLine = toLine;
            }
        } catch (IllegalArgumentException e) {
        }
    }

    public String read(String filePath) {
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

    public String readLines(int fromLine, int toLine)throws IndexOutOfBoundsException {
        List<String> listOfLines;
        listOfLines = Arrays.asList(this.read("src/main/resources/text_file.txt").split("\\r?\\n"));
        int numberOfLines = listOfLines.size();
        StringBuilder stringResult = new StringBuilder();

        if (fromLine == 1 && toLine == 1) {
            stringResult.append(listOfLines.get(0)+"\n");
        } else if (fromLine > toLine) {
            System.out.println("First argument must be smaller or equal to second argument.");
            throw new IndexOutOfBoundsException();
        } else if (toLine > numberOfLines) {
            for (int i = fromLine-1; i < numberOfLines; i++) {
                stringResult.append(listOfLines.get(i)+"\n");
            }
        } else {
            for (int i = fromLine-1; i < toLine; i++) {
                stringResult.append(listOfLines.get(i)+"\n");
            }
        }
        return stringResult.toString();

    }

}
