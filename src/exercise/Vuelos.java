package exercise;

import java.util.List;

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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
