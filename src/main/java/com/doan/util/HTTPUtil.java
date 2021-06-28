package com.doan.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HTTPUtil {

    public static final String HTTP_URL_INSERT = "http://localhost:8181/Account/Telegram/InsertBotId";

    public static final String HTTP_URL_DELETE = "http://localhost:8181/Account/Telegram/DeleteBotId";

    public void GetRequest(String telegramUsername, Long botIdTelegram, String HTTP_URL) throws IOException {
        String urlAddress = HTTP_URL + "?telegramUsername=" + telegramUsername + "&botId=" + botIdTelegram;
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
    }
    public void GetRequest(String telegramUsername, String HTTP_URL) throws IOException {
            String urlAddress = HTTP_URL + "?telegramUsername="+telegramUsername;
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
    }
}
