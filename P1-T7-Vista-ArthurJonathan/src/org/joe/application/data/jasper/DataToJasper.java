/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.data.jasper;

import java.awt.Desktop;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import org.joe.application.constants.ErrMsg;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

public class DataToJasper {

    private String urlJRS;
    private String userJRS;
    private String passwordJRS;
    private static final int BUFFER_SIZE = 4096;

    public DataToJasper() {
        String propFileName = "jasper.properties";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propFileName));
        } catch (FileNotFoundException ex) {
            ErrMsg.error(ex.getMessage(), ex.getCause());
        } catch (IOException ex) {
            ErrMsg.error(ex.getMessage(), ex.getCause());
        }

        urlJRS = prop.getProperty("url");
        userJRS = prop.getProperty("user");
        passwordJRS = prop.getProperty("password");

        if (urlJRS == null || urlJRS.isBlank()) {
            throw new EquipDataInterfaceException("URL is empty or null.");
        }
        if (userJRS == null || userJRS.isBlank()) {
            throw new EquipDataInterfaceException("User is empty or null.");
        }
        if (passwordJRS == null || passwordJRS.isBlank()) {
            throw new EquipDataInterfaceException("Password is empty or null.");
        }
    }

    public void getReport(String temporada, String categoria, String equipo) throws MalformedURLException, ProtocolException, IOException {

        StringBuilder urlBuilder = new StringBuilder(urlJRS);
        urlBuilder.append("InformeEquipo.pdf");

        List<String> params = new ArrayList<>();

        // Only add parameters that have values
        if (temporada != null && !temporada.isBlank()) {
            params.add("Temporada=" + encodeURIComponent(temporada));
        }
        if (categoria != null && !categoria.isBlank()) {
            params.add("Categoria=" + encodeURIComponent(categoria));
        }
        if (equipo != null && !equipo.isBlank()) {
            params.add("Equipo=" + encodeURIComponent(equipo));
        }

        if (!params.isEmpty()) {
            urlBuilder.append("?").append(String.join("&", params));
        }

        String url = urlBuilder.toString();
        System.out.println("Connecting to: " + url);

        // Create connection
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        // Set up Basic Authentication
        String auth = Base64.getEncoder().encodeToString((userJRS + ":" + passwordJRS).getBytes());
        con.setRequestProperty("Authorization", "Basic " + auth);

        // Get the response code
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Generate the file name dynamically
            String fileName = "InformeEquipo";
            if (equipo != null && !equipo.isBlank()) {
                fileName += "-" + equipo;
            }
            if (categoria != null && !categoria.isBlank()) {
                fileName += "-" + categoria;
            }
            fileName += ".pdf";

            try (InputStream inputStream = con.getInputStream(); FileOutputStream outputStream = new FileOutputStream(fileName)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File downloaded: " + fileName);
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().open(new File(fileName));
                    } catch (IOException ex) {
                        System.err.println("No applications available to open the file.");
                    }
                }
            }
        } else {
            System.err.println("GET request failed: " + url);
            System.err.println("Response Code: " + responseCode);

            // Print error stream for more details
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode >= 400 ? con.getErrorStream() : con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.err.println("Server response: " + response.toString());
            }
        }

        // Disconnect the connection
        con.disconnect();
    }

    // Helper method to encode URL parameters
    private static String encodeURIComponent(String value) {
        try {
            return java.net.URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("URL encoding failed", ex);
        }
    }

}
