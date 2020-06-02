package com.codecool;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void getWordsOrderedAlphabetically() {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/main/resources/text_file.txt",2,5);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(fileReader);
        List<String> result= analyzer.getWordsOrderedAlphabetically();
        List<String> expected = Arrays.asList("a", "a","a", "a", "amount", "by", "contents", "create", "different", "do", "file",
                    "file", "file", "from", "from", "how", "how", "how", "i", "in", "java", "java", "line", "lines", "n", "new", "of",
                    "of", "of", "read", "reading", "solos", "split", "string", "string", "text", "the", "to", "to", "ways");
        assertArrayEquals(expected.toArray(),result.toArray());
    }

    @Test
    void getWordsContainingSubstring() {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/main/resources/text_file.txt",1,10);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(fileReader);
        List<String> result = analyzer.getWordsContainingSubstring("fi");
        List<String> expected = Arrays.asList("files", "file", "file", "file", "files", "file", "file", "file");
        assertArrayEquals(expected.toArray(),result.toArray());

    }

    @Test
    void getStringsWhichPalindromes() {
        FilePartReader fileReader = new FilePartReader();
        fileReader.setup("src/main/resources/text_file.txt",1,10);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(fileReader);
        List<String> result = analyzer.getStringsWhichPalindromes();
        List<String> expected = Arrays.asList("solos", "sagas", "madam", "racecar");
        assertArrayEquals(expected.toArray(),result.toArray());
    }
}