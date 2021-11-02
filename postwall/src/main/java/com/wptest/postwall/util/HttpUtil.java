package com.wptest.postwall.util;

import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Map;

public class HttpUtil {

    private static String readJson(HttpURLConnection conn) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String line;
        StringBuilder jsonBuilder = new StringBuilder("");
        while ((line = br.readLine()) != null) {
            jsonBuilder.append(line);
        }

        return jsonBuilder.toString();
    }

    public static String getRequest(String urlString) throws IOException {
        return getRequestWithParameters(urlString, null);
    }

    public static String getRequestWithParameters(String urlString, Map<String, String> keyValues) throws IOException {

        URL url = new URL(buildParameterUrlString(urlString, keyValues));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        String json = readJson(conn);

        conn.disconnect();

        return json;
    }

    private static String buildParameterUrlString(String url, Map<String, String> keyValues) {
        StringBuilder parameters = new StringBuilder("");
        if (!CollectionUtils.isEmpty(keyValues)) {
            parameters.append("?");
            for (String key : keyValues.keySet()) {
                parameters.append(key)
                        .append("=")
                        .append(keyValues.get(key))
                        .append("&");
            }
        }
        return url+parameters;
    }


}
