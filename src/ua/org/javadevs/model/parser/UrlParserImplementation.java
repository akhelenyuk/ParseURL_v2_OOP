package ua.org.javadevs.model.parser;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public class UrlParserImplementation implements UrlParser {
    private final String wordsSplitPattern = "[-\\s\\.,;\\r\\n]";

    @Override
    public List<String> splitContentByWords(String urlContent, List<String> wordsList) {

        String[] wordsFromContentString = urlContent.split(wordsSplitPattern);
        for (String word : wordsFromContentString
                ) {
            if (word.matches("") ||
                    word.matches(".*\\p{Punct}.*") ||
                    word.matches(".*\\d.*") ||
                    word.matches("[—’”–]")) {
//                wordsIgnored.add(word);
                continue;
            }
            wordsList.add(word);
        }


        return null;
    }

    @Override
    public void sortWords(List<String> wordList, Map<String, Integer> wordListMap) {
        for (String word : wordList) {
            if (!addWordToMap(word, wordListMap)) {
                wordListMap.put(word, 1);
            }
        }
    }

    @Override
    public void showSortedWords(Map<String, Integer> wordListMap) {
        for (Map.Entry<String, Integer> entry : wordListMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private boolean addWordToMap(String word, Map<String, Integer> wordListMap) {
        for (Map.Entry<String, Integer> entry : wordListMap.entrySet()
                ) {
            if (entry.getKey().equalsIgnoreCase(word)) {
                entry.setValue(entry.getValue() + 1);
                return true;
            }
        }
        return false;
    }
}
