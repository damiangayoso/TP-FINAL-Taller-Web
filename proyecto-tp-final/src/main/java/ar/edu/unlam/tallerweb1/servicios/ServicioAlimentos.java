package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.*;

public interface ServicioAlimentos {

	List<Alimento> obtenerListadoDeAlimentos();
	
	List<Alimento> obtenerListadoDeAlimentos(String tipo);

	void guardarAlimento(Alimento alimento);

	Alimento getAlimentoById(Long id);

	void guardarRegistroComida(HistorialComidas registro);

	List<HistorialComidas> obtenerRegistroComidas(Long idPaciente);
	
}