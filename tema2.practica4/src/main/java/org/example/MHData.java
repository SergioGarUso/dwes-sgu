package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MHData {

    private static final String MH_API = "https://mhw-db.com/monsters/";

    public static Monstruo getMonstruoName(String name) {
        try {
            URL url = new URL(MH_API + name.toLowerCase());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Error HTTP: " + connection.getResponseCode());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content.toString(), Monstruo.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
