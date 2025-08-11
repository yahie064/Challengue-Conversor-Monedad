import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    private static final String API_KEY = "886237570efb9a88495abfd1";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public String obtenerDatos(String monedaBase, String monedaDestino, double cantidad) {
        String url = URL_BASE + monedaBase + "/" + monedaDestino + "/" + cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error en la conexión con la API: " + e.getMessage());
        }
    }
}