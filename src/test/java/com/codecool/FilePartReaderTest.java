package com.codecool;

import javax.sound.sampled.Line;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @org.junit.jupiter.api.Test
    void setup() {
        FilePartReader fileReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> fileReader.setup("src/main/resources/text_file.txt",fileReader.setFromLine(-1),fileReader.setToLine(2)));
        assertThrows(IllegalArgumentException.class, ()-> fileReader.setup("src/main/resources/text_file.txt",fileReader.setFromLine(8),fileReader.setToLine(2)));
    }

    @org.junit.jupiter.api.Test
    void read() {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/main/resources/text_file.txt",2,5);
        String result = fileReader.read();
        String expected = "1.Files in Java might be tricky, but it is fun enough!\n" +
                        "2.How to Split String by New Line\n" +
                        "3.How to read N amount of lines from a file?\n" +
                        "4.How do I create a Java string from the contents of a file? Solos\n" +
                        "5.Different ways of Reading a text file in Java\n" +
                        "6.Files in Java might be tricky, but it is fun enough! Sagas\n" +
                        "7.How to Split String by New Line madam\n" +
                        "8.How to read N amount of lines from a file?\n" +
                        "9.How do I create a Java string from the contents of a file?\n" +
                        "10.Different ways of Reading a text file in Java racecar\n";
        assertEquals(expected,result);
    }

    @org.junit.jupiter.api.Test
    void readLines() {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/main/resources/text_file.txt",2,5);
        String result = fileReader.readLines();
        String expected = "2.How to Split String by New Line3.How to read N amount of lines from a file?4.How do I create a Java string from the contents of a file? Solos5.Different ways of Reading a text file in Java";

        assertEquals(expected, result);
    }
}