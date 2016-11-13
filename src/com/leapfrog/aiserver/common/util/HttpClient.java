/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.aiserver.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author USER
 */
public class HttpClient {

    private String getContent(InputStream istream)throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            System.out.println(line);
        }
        reader.close();
        return buffer.toString();
    }

    public String get(String link) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
        return getContent(conn.getInputStream());
    }

    public String post(String link, String param) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
        conn.setDoOutput(true);
        conn.getOutputStream().write(param.getBytes());
        return getContent(conn.getInputStream());
    }
}
