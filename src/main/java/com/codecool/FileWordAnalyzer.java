package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader fileReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.fileReader = filePartReader;
    }

    public FilePartReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FilePartReader fileReader) {
        this.fileReader = fileReader;
    }

    public List getListOnlyWithWords(){
        String initialString = fileReader.readLines().replaceAll("[\\d\\?\\!\\,]", "").replaceAll("\\."," ");
        initialString = initialString.substring(1, initialString.length());
        List<String> list = Arrays.asList(initialString.toLowerCase().split(" "));
        return list;
    }

    public List getWordsOrderedAlphabetically (){
        List<String> listToOrder = getListOnlyWithWords();
        Collections.sort(listToOrder);
        return listToOrder;

    }

    public List getWordsContainingSubstring (String subString ){
        List<String> listToOrder = getListOnlyWithWords();
        List<String> resultList = new ArrayList<>();
        for(int i=0; i < listToOrder.size(); i++){
            if(listToOrder.get(i).contains(subString)){
                resultList.add(listToOrder.get(i));
            }
        }
        return resultList;
    }

    public List getStringsWhichPalindromes (){
        List<String> listToOrder = getListOnlyWithWords();
        List<String> resultList = new ArrayList<>();
        for(int i=0; i < listToOrder.size(); i++){
            if(listToOrder.get(i).equals(new StringBuilder(listToOrder.get(i)).reverse().toString()) && listToOrder.get(i).length() >1)
                resultList.add(listToOrder.get(i));
        }
        return resultList;
    }
}
