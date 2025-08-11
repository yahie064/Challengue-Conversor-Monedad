import com.google.gson.Gson;

public class ConversorMoneda {
    private Consulta consultaApi;
    private Gson gson;

    public ConversorMoneda() {
        this.consultaApi = new Consulta();
        this.gson = new Gson();
    }

    public double convertir(String monedaBase, String monedaDestino, double cantidad) {
        String json = consultaApi.obtenerDatos(monedaBase, monedaDestino, cantidad);
        Respuesta respuesta = gson.fromJson(json, Respuesta.class);
        if ("success".equalsIgnoreCase(respuesta.getResult())) {
            return respuesta.getConversion_result();
        } else {
            throw new RuntimeException("Error en la conversión. Verifica las monedas.");
        }
    }
}