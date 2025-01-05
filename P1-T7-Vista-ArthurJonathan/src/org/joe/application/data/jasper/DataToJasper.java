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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
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

    public void getReport(String temporada, String categoria, String equipo) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(urlJRS);
        urlBuilder.append("reports/EquipoReport.pdf");

        boolean hasParams = false;

        if (temporada != null && !temporada.isBlank()) {
            urlBuilder.append(hasParams ? "&" : "?");
            urlBuilder.append("Temporada=").append(encodeURIComponent(temporada));
            hasParams = true;
        }

        if (categoria != null && !categoria.isBlank()) {
            urlBuilder.append(hasParams ? "&" : "?");
            urlBuilder.append("Categoria=").append(encodeURIComponent(categoria));
            hasParams = true;
        }

        if (equipo != null && !equipo.isBlank()) {
            urlBuilder.append(hasParams ? "&" : "?");
            urlBuilder.append("Equipo=").append(encodeURIComponent(equipo));
        }

        String url = urlBuilder.toString();
        System.out.println("Connecting to: " + url);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        String auth = Base64.getEncoder().encodeToString((userJRS + ":" + passwordJRS).getBytes());
        con.setRequestProperty("Authorization", "Basic " + auth);
        con.setRequestProperty("Accept", "application/pdf");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {

            String timestamp = new SimpleDateFormat("ddMMyyyy").format(new Date());
            String fileName = String.format("Informe_Equipo_%s_%s_%s.pdf",
                    equipo != null ? equipo : "Todos",
                    categoria != null ? categoria : "Todas",
                    timestamp);

            String userHome = System.getProperty("user.home");
            File downloadsFolder = new File(userHome, "Downloads");
            File outputFile = new File(downloadsFolder, fileName);

            try (InputStream inputStream = con.getInputStream(); FileOutputStream outputStream = new FileOutputStream(outputFile)) {

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("File downloaded: " + outputFile.getAbsolutePath());

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(outputFile);
                }
            }
        } else {
            System.err.println("GET request failed: " + url);
            System.err.println("Response Code: " + responseCode);

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

        con.disconnect();
    }

    private static String encodeURIComponent(String value) {
        try {
            return java.net.URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("URL encoding failed", ex);
        }
    }
}
