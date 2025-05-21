package exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
	public Map<LocalDate, Integer> fechaNumPasajeros(){
		
		Map<LocalDate, Integer> pasajerosFecha = new HashMap<>();
		
		for(Vuelo v: vuelos) {
			LocalDate fecha = v.getFecha();
			pasajerosFecha.put(fecha, pasajerosFecha.getOrDefault(fecha, 0) + v.getNumPasajeros());
		}
		return pasajerosFecha;
	}

	public Map<String, List<String>> destinoListaCodigos(){
		
		Map<String, List<String>> codigosDestino = new HashMap<>();
		
		for (Vuelo v: vuelos) {
			String destino = v.getDestino();
			List<String> codigos = codigosDestino.getOrDefault(destino, new ArrayList<>());
			
			codigos.add(v.getCodigo());
			
			codigosDestino.put(destino, codigos);

		}

		return codigosDestino;

		
	}
	
	public Map<String, Set<LocalDate>>  fechasVuelosDestinoLibres(){
		Map<String, Set<LocalDate>> destinoFechas = new HashMap<>();
		
		for(Vuelo v: vuelos) {
			String destino = v.getDestino();
			Set<LocalDate> fechas = destinoFechas.getOrDefault(destino, new HashSet<>());
			if(v.getPlazasDisponibles()>0) {
				fechas.add(v.getFecha());
				destinoFechas.put(destino, fechas);
				
			}	
		}
		
		return destinoFechas;
	}
	
	public Map<String, SortedSet<LocalDate>> fechasDestinoOrdenadas(){
		Map<String, SortedSet<LocalDate>> destinoFechas = new HashMap<>();
		
		for (Vuelo v: vuelos) {
			String destino = v.getDestino();
			LocalDate fecha = v.getFecha();
			
			SortedSet<LocalDate> fechas = destinoFechas.getOrDefault(destino, new TreeSet<>());
			
			fechas.add(fecha);
			
			destinoFechas.put(destino, fechas); 	
			
			
			
		}
		
		
		return destinoFechas;
		
	}
	
	public SortedSet<Vuelo> obtenerVuelosOrdenadosPorFecha(List<Vuelo> vuelos) {
	    SortedSet<Vuelo> vuelosOrdenados = new TreeSet<>(Comparator.comparing(v ->v.getFecha()));

	    for (Vuelo v : vuelos) {
	        vuelosOrdenados.add(v);
	    }

	    return vuelosOrdenados;
	}
	
	public LocalDate diaMenosPasajeros() {
		
		LocalDate dia = null;
		Map<LocalDate, Integer> fechaPasajeros = new HashMap<>();
		
		for(Vuelo v: vuelos) {
			LocalDate fecha = v.getFecha();
			Integer pasajeros = v.getNumPasajeros();
			
			fechaPasajeros.put(fecha, fechaPasajeros.getOrDefault(fecha, 0) + pasajeros);
			
		}
		 dia = fechaPasajeros.entrySet()
		            .stream()
		            .min(Map.Entry.comparingByValue())  // compara por número de pasajeros
		            .map(Map.Entry::getKey)             // obtenemos la fecha (clave)
		            .orElse(null);                      // por si el mapa está vacío

		    return dia;
		
		
		
	}
	public Boolean existeVueloDestino(String destino) {
		Boolean res = false;
		
		res = vuelos.stream()
				.anyMatch(v -> v.getDestino().equals(destino));
		
		return res;
	}

	public Boolean todosVuelosNPasajeros(int n) {
		Boolean res = false;
		
		res = vuelos.stream()
				.allMatch(v -> v.getNumPasajeros() == n);
		
		return res;
	}
	
	public List<Vuelo> vuelosPostFecha(LocalDate fecha){
		
		return vuelos.stream()
				.filter(v -> v.getFecha().isAfter(fecha))
				.collect(Collectors.toList());
		
	}

	
	public List<Vuelo> vuelosNBaratos(Integer n){
		
		return vuelos.stream()
				.sorted(Comparator.comparingDouble(v -> v.getPrecio()))
				.limit(n)
				.collect(Collectors.toList());
		
	}
	
	public Long numDestinosDifFecha(LocalDate fecha) {
		
		return vuelos.stream()
			.filter(v -> v.getFecha().equals(fecha))
			.map(v -> v.getDestino())
			.distinct()
			.count();
			
	}
	public Set<Vuelo> ordenNaturalTipo(){
		
		return vuelos.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		
	}
	// agrupar vuelos por fecha
	
	public Map<LocalDate, List<Vuelo>> fechasVuelos(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(v -> v.getFecha()));		
	}
	
	public Map<LocalDate, List<Double>> fechasPrecios(){
		return vuelos.stream()
				.collect(Collectors.groupingBy(v -> v.getFecha(),
						Collectors.mapping(v-> v.getPrecio(), Collectors.toList())));		
	}
	
	public Map<LocalDate, Double> fechasMediasPrecios() {
	    return vuelos.stream()
	        .collect(Collectors.groupingBy(
	            v -> v.getFecha(),
	            Collectors.averagingDouble(v -> v.getPrecio())
	        ));
	}

	
	public Map<LocalDate, Set<String>> fechaDestinos(){
		
		return vuelos.stream()
				.collect(Collectors.groupingBy(
						v -> v.getFecha(),
						Collectors.mapping(v -> v.getDestino(), Collectors.toSet())));
	}	
	
	public Map<LocalDate, Set<Double>> fechaPreciosAscendentes(){
		
		return vuelos.stream()
				.collect(Collectors.groupingBy(
						v -> v.getFecha(),
						Collectors.mapping(v -> v.getPrecio(),
								Collectors.toCollection(() -> new TreeSet<>((a, b) -> b.compareTo(a))
										))));
	}
	public Map<String, List<String>> origenesVuelosTripulante(){
		Map<String, List<String>> vuelosTripulante = new HashMap<>();
		
		vuelosTripulante = vuelos.stream()
				.collect(Collectors.groupingBy(v -> v.getOrigen(),
						Collectors.flatMapping(v -> v.getTripulacion().stream(), Collectors.toList())));
		
		return vuelosTripulante;
	}

	
	
}
