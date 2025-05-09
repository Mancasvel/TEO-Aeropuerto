package exercise;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Vuelos {
	
	private String nombre;
	private List<Vuelo> vuelos;
	private Integer numVuelos;
	private Integer numPasajeros;
	private Double precioMedio;

	


	public Vuelos(String nombre, List<Vuelo> vuelos, Integer numVuelos, Integer numPasajeros, Double precioMedio,
			Integer numDestinos) {
		super();
		this.nombre = nombre;
		this.vuelos = vuelos;
		this.numVuelos = numVuelos;
		this.numPasajeros = numPasajeros;
		this.precioMedio = precioMedio;
		this.numDestinos = numDestinos;
	}
	public String getNombre() {
		return nombre;
	}
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public Integer getNumVuelos() {
		return numVuelos;
	}
	private Integer numDestinos;
	public Integer getNumDestinos() {
		return numDestinos;
	}
	public Double getPrecioMedio() {
		return precioMedio;
	}
	public Integer getNumPasajeros() {
		return numPasajeros;
	}
	
	

	@Override
	public String toString() {
		return "Vuelos [nombre=" + nombre + ", vuelos=" + vuelos + ", numVuelos=" + numVuelos + ", numPasajeros="
				+ numPasajeros + ", precioMedio=" + precioMedio + ", numDestinos=" + numDestinos + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Vuelos)) return false; 
		 Vuelos that = (Vuelos) obj;                        // Ahora es seguro hacer cast
		    return Objects.equals(nombre, that.nombre) &&
		           Objects.equals(vuelos, that.vuelos);
	}
	
	public Integer getNumPasajerosDestino(String destino) {
		
		return vuelos.stream()
				.filter(v -> v.getDestino().equals(destino))
				.mapToInt(v -> v.getNumPasajeros())
				.sum();
	}
	public void incorporaVuelo(Vuelo v) {
		if (!vuelos.contains(v)) {
			vuelos.add(v);
		}
	}
	public void incorporaVuelos(Collection<Vuelo> vuelos) {
		for(Vuelo v : vuelos) {
			if(!vuelos.contains(v)) {
				vuelos.add(v);
			}
		}
	}
	public void eliminaVuelo(Vuelo v) {
		if(vuelos.contains(v)) {
			vuelos.remove(v);
		}
	}
	public void ordena() {
		Collections.sort(vuelos);
	}
	public Boolean existeVueloDestino(String destino) {
		for(Vuelo v : vuelos) {
			if(v.getDestino().equals(destino)) {
				return true;
				
			}
			
		}
		return false;
		
		
	}
}
