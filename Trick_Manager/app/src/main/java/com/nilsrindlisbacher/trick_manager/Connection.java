package com.nilsrindlisbacher.trick_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
        private static final String GET_TYPES = "http://192.168.124.135:8080/types";
        private static final String GET_TRICKS = "http://192.168.124.135:8080/tricks";

        private static String getTypes() throws IOException {
            URL obj = new URL(GET_TYPES);

            return "";
        }

        public static String getTricks() throws IOException {
            URL obj = new URL(GET_TRICKS);

            return "";
        }

    public static String getRandomTrick() throws IOException {
            String tricks = getTricks();
            
            return "";
    }
}
