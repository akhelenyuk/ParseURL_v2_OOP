package ua.org.javadevs.model.parser;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public interface UrlParser {
    List<String> splitContentByWords(String urlContent, List<String> wordsList);

    void sortWords(List<String> wordList, Map<String, Integer> wordListMap);

    void showSortedWords(Map<String, Integer> wordListMap);
}
