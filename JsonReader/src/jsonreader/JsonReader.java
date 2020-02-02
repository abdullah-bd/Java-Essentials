/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonreader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author spark
 */
public class JsonReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String data = "";
        String dataParsed = "";
        String singleParsed = "";
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }
            System.out.println(data);
            System.out.println();
        } catch (Exception ex) {
            System.out.println("ERR 0 -->" + ex);
        }
        try {
            JSONArray JA = new JSONArray(data);

            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name:" + JO.get("name") + "\n"
                        + "Password:" + JO.get("email") + "\n"
                        + "Contact:" + JO.get("address") + "\n"
                        + "Country:" + JO.get("website") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";

            }
            System.out.println(dataParsed);

        } catch (Exception ex) {
            System.out.println("ERR 1 -->" + ex);
        }

    }

}
