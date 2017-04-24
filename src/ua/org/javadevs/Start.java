package ua.org.javadevs;

import ua.org.javadevs.model.*;
import ua.org.javadevs.model.parser.UrlParser;
import ua.org.javadevs.model.parser.UrlParserImplementation;
import ua.org.javadevs.model.checker.UrlChecker;
import ua.org.javadevs.model.checker.UrlCheckerImplementation;
import ua.org.javadevs.model.reader.MyUrlReader;
import ua.org.javadevs.model.reader.MyUrlReaderImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public class Start {
    private static ArrayList<String> errors;

    public static void main(String[] args) {

        while (true) {
            errors = new ArrayList<>();
            // step 1: getting url from user
            String userUrl = User.getUrlFromUser(errors);
            if (userUrl == null) {
                showErrors();
                continue;
            }

            //step 2: checking whether url matches pattern and is accessible
            UrlChecker urlChecker = new UrlCheckerImplementation();
            if (!urlChecker.urlMatchesPattern(userUrl, errors) || !urlChecker.urlIsAccessible(userUrl, errors)) {
                showErrors();
                continue;
            }

            //step 3: read content from the page
            MyUrlReader urlReader = new MyUrlReaderImplementation();
            String urlContent = urlReader.getUrlContent(userUrl);
            if (urlContent == null) {
                System.out.println("No content found!");
                continue;
            }

            //step 4: split content by word and write them to ArrayList
            UrlParser urlParser = new UrlParserImplementation();
            List<String> wordList = new ArrayList<>();
            urlParser.splitContentByWords(urlContent, wordList);
            System.out.println("Total number of words: " + wordList.size());

            //step 5: sort words by adding them to Map with key - word and value - number of found instances
            Map<String, Integer> wordListMap = new TreeMap<>();

            urlParser.sortWords(wordList, wordListMap);

            System.out.println("Total number of SORTED words: " + wordListMap.size());

            urlParser.showSortedWords(wordListMap);






        }

    }

    private static void showErrors() {
        if (errors != null) {
            for (String error : errors)
                System.out.println(error);
        } else System.out.println("Unknown error");
    }


}

