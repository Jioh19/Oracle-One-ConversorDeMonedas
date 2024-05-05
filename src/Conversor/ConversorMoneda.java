package Conversor;

import Model.Conversion;
import Model.Monedas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {

    final static String API_KEY = "90806ed8a0b3d86475e73a3a";

    public static Conversion convertirMoneda(String base,
                                      String destino,
                                      double monto) {


        String uri = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%f",
                API_KEY, base, destino, monto);
        URI direccion = URI.create(uri);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Error de Runtime");
        }
    }

    public static Monedas getMonedas() {
        String uri = String.format("https://v6.exchangerate-api.com/v6/%s/codes",
                API_KEY);
        URI direccion = URI.create(uri);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("Error de Runtime");
        }
    }
}
