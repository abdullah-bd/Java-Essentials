/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrssreader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author spark
 */
public class MyRSSReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readRSS("http://rss.cnn.com/rss/edition.rss");
    }

    public static void readRSS(String rssAddress) {
        try {
            URL rssURL = new URL(rssAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssURL.openStream()));
            
            PrintWriter writer = new PrintWriter("a.txt", "UTF-8");
            while (in.readLine() != null) {
                
                writer.println(in.readLine());
                
                
            }
            writer.close();
            System.out.println("Successful!!");
        } catch (Exception ex) {
            System.err.println(ex);
            System.out.println("Failed!!");
        }
        
    }
}
