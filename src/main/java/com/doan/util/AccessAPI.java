package com.doan.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;

public class AccessAPI {
    public static Double getUSDVND() throws IOException {
        String urlAddress = "https://fcsapi.com/api-v3/forex/latest?id=1893&access_key=dW6F36QY9tqNHoj2eRj7";
        URL obj = new URL(urlAddress);
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();



        // Thực hiện đọc
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        JSONArray jsonArray = new JSONArray(jsonObject.get("response").toString());
        JSONObject responseINAPI = new JSONObject(jsonArray.get(0).toString());
        Double money = responseINAPI.getDouble("o");

        return money;
    }
}
