package ua.org.javadevs.model.reader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;

/**
 * Created by Oleksandr on 12.03.2017.
 */
public class MyUrlReaderImplementation implements MyUrlReader {
    @Override
    public String getUrlContent(String userUrl) {

        String page = new String();
        try {
            URL url = new URL(userUrl);
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream(),"UTF-8"));

            String string = reader.readLine();
            while (string != null) {
                page += string + "/r";
                string = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(page.equals("")){
                page = null;
            }
            return page;
        }
//

    }
}


//        URLConnection connection = null;
//        try {
//            connection = new URL(userUrl).openConnection();
//            BufferedInputStream buffer = new BufferedInputStream(connection.getInputStream());
//            connection.getin
//            int byteRead;
//            while ((byteRead = buffer.read()) != -1){
//                System.out.println((char) byteRead);
//                String urlContent = new String(String.valueOf(byteRead));
//            }
//            buffer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;