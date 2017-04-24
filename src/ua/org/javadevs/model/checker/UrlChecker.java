package ua.org.javadevs.model.checker;

import java.util.ArrayList;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public interface UrlChecker {

    boolean urlMatchesPattern(String userUrl, ArrayList<String> errors);

    boolean urlIsAccessible(String userUrl, ArrayList<String> errors);
}
