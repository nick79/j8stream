package com.mnblog;

/**
 * Created by Milan.Nikic on 8/4/2016.
 */
public class ReadFileApp {

    public static void main(String[] args) {
        String inputFile = "enable1-word-list.txt";
        String fiveLetterOutputFile = "five-letter-words.txt";
        String wordsWithBOutputFile = "words-with-b.txt";

        getFiveLetterWords(inputFile, fiveLetterOutputFile);
        getWordsWithB(inputFile, wordsWithBOutputFile);
    }

    private static void getFiveLetterWords(String inputFile, String outputFile) {
        StreamProcessor.processFile(inputFile, outputFile, new FiveLetterWords());
    }

    private static void getWordsWithB(String inputFile, String outputFile) {
        StreamProcessor.processFile(inputFile, outputFile, new WordsWithB());
    }
}
