package com.Moneda.Conversion.com;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumiendoApi {



    public static double cosumiendoapi(Datos datos) throws IOException, InterruptedException {

        String  _divisaentrada;
        String divisaSalida;
        try {

            String dirrecion = "https://v6.exchangerate-api.com/v6/4fa2d5de5cd26b7151abbdde/pair/" +
                    datos.getDivisiaConvertir() + "/" +
                    datos.getDivisaAconvertir() + "/" +
                    datos.getCantidaConvertir();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dirrecion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            //acceder a dato especifico

            _divisaentrada = jsonObject.get("base_code").getAsString();
            divisaSalida = jsonObject.get("target_code").getAsString();
            double resultado = (jsonObject.get("conversion_result").getAsDouble());

            _divisaentrada.toUpperCase();
            divisaSalida.toUpperCase();

            String resumen = "Convertir " + datos.
                    getDivisiaConvertir()+ " a " + datos.getDivisaAconvertir() +
                    " - Cantidad: " + datos.getCantidaConvertir() +
                    " - Resultado: " + resultado;

            datos.agregarResumenBusqueda(resumen);
            System.out.println();
            System.out.println("*****************************++*");
            System.out.println("----RESULTADO DE LA CONVERSION--- ");
            System.out.println("**********************************");
            System.out.println();
            System.out.println("CONVERTIR : "
                    + _divisaentrada + " A " + divisaSalida +
                    " CANTIDAD  "  + datos.getCantidaConvertir() + "-"+
                      datos.getDivisiaConvertir()
                    + " RESULTADO DE LA CONVERSION : "  + resultado + "-" + datos.getDivisaAconvertir());
                   System.out.println();

        } catch(IOException e){
            System.out.println("Error al conectar con la API: " + e.getMessage());
        } catch(InterruptedException e){
            System.out.println("Error de interrupción: " + e.getMessage());

        } catch(Exception e){
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }


        return 0;
    }

}



