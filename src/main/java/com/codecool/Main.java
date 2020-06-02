package com.codecool;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilePartReader textFromFile = new FilePartReader();
        String data = textFromFile.read("src/main/resources/text_file.txt");
//        System.out.println(data);
        textFromFile.setFromLine(1);
        textFromFile.setToLine(10);
        String readLines = textFromFile.readLines();
        System.out.println(readLines);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(textFromFile);
//      List<String> str1 = analyzer.getWordsOrderedAlphabetically();
//        for(String i: str1) {
//            System.out.println(i);
//        }
        List<String> str2 = analyzer.getWordsContainingSubstring("fi");
        for(String i: str2) {
            System.out.println(i);
        }

        List<String> str3 = analyzer.getStringsWhichPalindromes();
        for(String i: str3) {
            System.out.println(i);
        }
    }

}
