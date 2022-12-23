package service;

import model.Document;

import java.util.HashSet;
import java.util.Set;

/** Util to parse the document and get the valid words */
public class DocumentParser {

    private static Set<String> ignoreWords = new HashSet<>();

    static {
        ignoreWords.add("a");
        ignoreWords.add("is");
        ignoreWords.add("on");
        ignoreWords.add("come");
        ignoreWords.add("for");
    }

    public static Set<String> getWords(String text) {
        Set<String> resultWords = new HashSet<>();
        String[] parsedWords = text.split(" ");
        for (String word: parsedWords) {
            if (!ignoreWords.contains(word)) {
                resultWords.add(word);
            }
        }
        return resultWords;
    }
}
