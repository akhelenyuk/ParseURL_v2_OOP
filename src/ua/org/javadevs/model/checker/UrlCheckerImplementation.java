package ua.org.javadevs.model.checker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public class UrlCheckerImplementation implements UrlChecker {
    //Specifying 'Pattern.CASE_INSENSITIVE' flag may impose a slight performance penalty.
    private final Pattern pattern = Pattern.compile("(/s)*https?://[\\p{Graph}]+", Pattern.CASE_INSENSITIVE);


    @Override
    public boolean urlMatchesPattern(String userUrl, ArrayList<String> errors) {
        Matcher matcher = pattern.matcher(userUrl);
        if (!matcher.matches()) {
            errors.add("Ошибка! URL " + userUrl + " не соответсвует заданному формату.");
            return false;
        }
        return true;
    }


    @Override
    public boolean urlIsAccessible(String userUrl, ArrayList<String> errors) {
        URL url;
        HttpURLConnection connection;
        try {
            url = new URL(userUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
//            System.out.println(connection.getResponseCode());
            String type = connection.getHeaderField("Content-Type");
            if (type == null || !type.contains("text/html")) {
                errors.add("Ошибка! Данный url '" + url + "' не содержит html содержания.");
                return false;
            } else return true;

        } catch (MalformedURLException e) {
            errors.add(e.getMessage());
            return false;
        } catch (IOException e) {
            errors.add(e.getMessage());
            return false;
        }
    }


}
