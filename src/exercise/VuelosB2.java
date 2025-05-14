package exercise;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Vuelo vueloMenorFechaPrecioDestino(String destino) {
		Vuelo mejorVuelo = null;
		for(Vuelo v: vuelos) {
			if(v.getDestino().equals(destino)) {
				// 1 saber si lista vacia 2 comparar fecha 3 si fecha igual comparar precio
				if(mejorVuelo == null 
						|| v.getFecha().isBefore(mejorVuelo.getFecha())
						|| v.getFecha().isEqual(mejorVuelo.getFecha()) && v.getPrecio() < mejorVuelo.getPrecio()) {
					mejorVuelo = v;
				}
			}
		}
		return mejorVuelo;
		
	}
	
	public Map<String, Integer> destinoNumVuelos(){
		Map<String, Integer> vueloDest = new HashMap<>();
		
		for(Vuelo v: vuelos){
			String destino = v.getDestino();
			vueloDest.put(destino, vueloDest.getOrDefault(vueloDest, 0)+ 1);

		}
		return vueloDest;
		
		
	}
	public Map<LocalDate, Integer> fechaNumVuelos(){
		Map<LocalDate, Integer> vuelosFecha = new HashMap<>();
		
		for(Vuelo v: vuelos) {
			LocalDate fecha = v.getFecha();
			vuelosFecha.put(fecha, vuelosFecha.getOrDefault(fecha, 0)+1);
		}
		
		return vuelosFecha;	
	}

}
