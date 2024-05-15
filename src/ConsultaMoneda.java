import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda convertirMoneda(int opcion, double cantidad ){

        String siglaMonedaOrigen="";
        String siglaMonedaCambio="";
        String apiKey= "88c3e552073d63789755c9f6";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                .setPrettyPrinting()
                .create();

        switch (opcion) {
            case 1:
                siglaMonedaOrigen="USD";
                siglaMonedaCambio="ARS";
                break;
            case 2:
                siglaMonedaOrigen="ARS";
                siglaMonedaCambio="USD";
                break;
            case 3 :
                siglaMonedaOrigen="USD";
                siglaMonedaCambio="BRL";
                break;
            case 4:
                siglaMonedaOrigen="BRL";
                siglaMonedaCambio="USD";
                break;
            case 5:
                siglaMonedaOrigen="USD";
                siglaMonedaCambio="COP";
                break;
            case 6 :
                siglaMonedaOrigen="COP";
                siglaMonedaCambio="USD";
                break;
            default:
                System.out.println("Opción Incorrecta");
                break;
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + siglaMonedaOrigen + "/" + siglaMonedaCambio +"/" +cantidad);

        System.out.println(direccion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            /*System.out.println(response.body());
            System.out.println(response.statusCode());*/

            //return gson.fromJson(response.body(), Moneda.class);
            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e) {
            throw new RuntimeException("No se pudo convertir esta moneda");
        }

    }
}
