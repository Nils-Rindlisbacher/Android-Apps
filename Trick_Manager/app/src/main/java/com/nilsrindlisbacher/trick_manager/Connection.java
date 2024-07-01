package com.nilsrindlisbacher.trick_manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Connection {
        private static final String GET_TYPES = "http://192.168.8.143:8080/types";
        private static final String GET_TRICKS = "http://192.168.8.143:8080/tricks";

    public static ArrayList<String> getTypes() throws IOException, JSONException {
        URL type_url = new URL(GET_TYPES);
        Gson gson = new Gson();
        Type typeListType = new TypeToken<ArrayList<String>>(){}.getType();

        return gson.fromJson(String.valueOf(getJson(type_url)), typeListType);
    }

    public static ArrayList<Trick> getTricks() throws IOException, JSONException {
        URL trickURL = new URL(GET_TRICKS);
        Gson gson = new Gson();
        Type trickListType = new TypeToken<ArrayList<Trick>>(){}.getType();

        return gson.fromJson(String.valueOf(getJson(trickURL)), trickListType);
    }

    public static String getRandomTrick(String type) throws IOException, JSONException {
        ArrayList<Trick> tricks = getTricks();
        ArrayList<Trick> tricksOfType = new ArrayList<>();

        for (Trick trick : tricks) if(trick.trick_type.equals(type)) tricksOfType.add(trick);

        return tricksOfType.get((int)(Math.random() * tricksOfType.size())).trick_name;
    }

    public static String getJson(URL url) throws JSONException, IOException {
        return IOUtils.toString(url, Charset.forName("UTF-8"));
    }
}
