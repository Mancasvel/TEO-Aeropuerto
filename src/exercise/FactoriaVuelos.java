package exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FactoriaVuelos {

    public static Vuelo parseaVuelo(String datosVuelo) {
        String[] partes = datosVuelo.split(";");
        
        String origen = partes[0];
        String destino = partes[1];
        double precio = Double.parseDouble(partes[2]);
        int numPasajeros = Integer.parseInt(partes[3]);
        int capacidad = Integer.parseInt(partes[4]);
        String codigo = partes[5];
        LocalDate fecha = parseaFecha(partes[6]);
        Duration duracion = parseaDuracion(partes[7]);
        List<String> tripulacion = parseaTripulacion(partes[8]);

        return new Vuelo(origen, destino, precio, numPasajeros, capacidad, codigo, fecha, duracion, tripulacion);
    }

    public static List<String> parseaTripulacion(String datosTripulacion) {
        return Arrays.asList(datosTripulacion.split(","));
    }

    public static LocalDate parseaFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formatter);
    }

    public static Duration parseaDuracion(String duracion) {
        int minutos = Integer.parseInt(duracion);
        return Duration.ofMinutes(minutos);
    }
}
