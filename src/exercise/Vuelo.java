package exercise;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo> {

    private String origen;
    private String destino;
    private double precio;
    private int numPasajeros;
    private int plazasDisponibles;
    private String codigo;
    private LocalDate fecha;
    private Duration duracion;
    private List<String> tripulacion;

    // Constructor
    public Vuelo(String origen, String destino, double precio, int numPasajeros, int plazasDisponibles,
                 String codigo, LocalDate fecha, Duration duracion, List<String> tripulacion) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.numPasajeros = numPasajeros;
        this.plazasDisponibles = plazasDisponibles;
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.tripulacion = tripulacion;
    }

    // Getters
    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public List<String> getTripulacion() {
        return tripulacion;
    }

    // toString para mostrar la info del vuelo (esto sirve para la cadena en Vuelos)
    @Override
    public String toString() {
        return String.format("%s -> %s | Precio: %.2f | Pasajeros: %d | Código: %s | Fecha: %s",
                origen, destino, precio, numPasajeros, codigo, fecha);
    }

    // equals y hashCode basados en el código (por ejemplo)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vuelo)) return false;
        Vuelo vuelo = (Vuelo) o;
        return codigo.equals(vuelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // Para orden natural, por ejemplo por fecha
    @Override
    public int compareTo(Vuelo o) {
        return this.fecha.compareTo(o.fecha);
    }
}
