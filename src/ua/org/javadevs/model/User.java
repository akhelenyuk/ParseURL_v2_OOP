package ua.org.javadevs.model;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public class User {
    public static String getUrlFromUser(List<String> errors) {
        String urlFromUser;
        Scanner scanner = new Scanner(System.in, "utf-8");

        System.setProperty("console.encoding", "utf-8");

        System.out.println("Пожалуйста, введите URL в формате http://google.com");
        urlFromUser = scanner.next();
        if (scanner != null) {
            return urlFromUser;
        }
        else{
            errors.add("Error while getting url from user.");
            return null;
        }
    }
}
