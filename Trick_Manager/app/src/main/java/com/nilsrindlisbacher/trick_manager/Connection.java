package com.nilsrindlisbacher.trick_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
        private static final String USER_AGENT = "Mozilla/5.0";

        private static final String GET_TYPES = "http://192.168.135.135:8080/types";
        private static final String GET_TRICKS = "http://192.168.135.135:8080/tricks";
        private static String getTypes() throws IOException {
            String json = "";

            URL obj = new URL(GET_TYPES);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    json = (inputLine);
                }
                in.close();

                return (json);

            } else {
                return ("GET request did not work.");
            }
        }

        public static String getTricks() throws IOException {
            String json = "";

            URL obj = new URL(GET_TRICKS);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    json = inputLine;
                }
                in.close();

                return (json);

            } else {
                return ("GET request did not work.");
            }
        }

    public static String getRandomTrick() throws IOException {
            String randomTrick = "";


            return randomTrick;
    }
}
