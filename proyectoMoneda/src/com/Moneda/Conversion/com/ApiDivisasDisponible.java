package com.Moneda.Conversion.com;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiDivisasDisponible {


    public static String apiDivisas(Datos datos) throws IOException, InterruptedException {
        try {


            String dirrecion = "https://v6.exchangerate-api.com/v6/4fa2d5de5cd26b7151abbdde/codes";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dirrecion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            List<String> divisasDisponibles = new ArrayList<>();
            JsonArray supportedCodes = jsonObject.getAsJsonArray("supported_codes");
            for (JsonElement code : supportedCodes) {
                JsonArray codeArray = code.getAsJsonArray();
                String divisaCode = codeArray.get(0).getAsString();
                String divisaName = codeArray.get(1).getAsString();
                divisasDisponibles.add(divisaCode + " - " + divisaName);
            }
            datos.setDivisasDisponible(divisasDisponibles);

            // Imprimir las divisas disponibles en columna
            for (String divisa : divisasDisponibles) {
                System.out.println(divisa);
            }

            return dirrecion;
        } catch (Exception e) {
            System.out.println("ERRROROROROR 404" + e.getMessage());
        }

        return null;
    }
}


