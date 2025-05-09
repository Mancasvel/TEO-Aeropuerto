package exercise;

import java.util.List;

public class VuelosB2 extends Vuelos{

	public VuelosB2(String nombre, List<Vuelo> vuelos, Integer numVuelos, Integer numPasajeros, Double precioMedio,
			Integer numDestinos) {
		super(nombre, vuelos, numVuelos, numPasajeros, precioMedio, numDestinos);
		// TODO Auto-generated constructor stub
	}
	
	public Integer pasajerosDestino(String destino) {
		Integer numTotal = 0;
		
		for(Vuelo v: vuelos) {
			if(v.getDestino().equals(destino)) {
				numTotal += v.getNumPasajeros();
			}
			
		}
		return numTotal;
		
	}
	public Integer pasajerosDestinoInicial(String inicial) {
		Integer numTotal= 0;
		for(Vuelo v: vuelos) {
			
			if(v.getDestino().startsWith(inicial)) {
				numTotal += v.getNumPasajeros();
			}
		}
		return numTotal;
		
	}
	public Double recaudacionDestino(String destino) {
		
		Double totalMoney = 0.0;
		for (Vuelo v : vuelos) {
			if(v.getDestino().equals(destino)) {
				totalMoney += v.getPrecio() * v.getNumPasajeros();
			}
		}
		return totalMoney;
	}
	
	public Vuelo vueloMenorFechaDestino(String destino) {
		Vuelo mejorVuelo = null;
		for(Vuelo v: vuelos) {
			if(v.getDestino().equals(destino)) {
				if(mejorVuelo == null || v.getPrecio() < mejorVuelo.getPrecio()) {
					mejorVuelo = v;
				}
			}
		}
		return mejorVuelo;
		
	}

}
