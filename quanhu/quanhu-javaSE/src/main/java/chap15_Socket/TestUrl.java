/*created by chenshi    at 2018-05-12*/
package chap15_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TestUrl {
    public static void  main(String[] args) throws IOException {
        URL url = new URL("https://wannianrili.51240.com/");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuilder stringBuilder = new StringBuilder();
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
            stringBuilder.append(line+"<br>");
        }

        bufferedReader.close();


    }
}
