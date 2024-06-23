package com.nilsrindlisbacher.trick_manager;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

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

    public static JSONObject getJson(URL url) throws JSONException, IOException {
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        return new JSONObject(json);
    }
}
