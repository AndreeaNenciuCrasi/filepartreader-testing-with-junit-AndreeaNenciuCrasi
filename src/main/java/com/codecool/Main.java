package com.codecool;

public class Main {
    public static void main(String[] args) {
        FilePartReader textFromFile = new FilePartReader();
        String data = textFromFile.read("src/main/resources/text_file.txt");
//        System.out.println(data);
        String readLines = textFromFile.readLines(1,10);
        System.out.println(readLines);
    }

}
