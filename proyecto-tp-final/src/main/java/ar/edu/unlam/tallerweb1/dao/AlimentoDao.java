package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Alimento;
import ar.edu.unlam.tallerweb1.modelo.HistorialComidas;

public interface AlimentoDao {

	List<Alimento> obtenerListadoDeAlimentos();

	List<Alimento> obtenerListadoDeAlimentos(String tipo);

	void guardarAlimento(Alimento alimento);

	Alimento getAlimentoById(Long id);

	void guardarRegistroComida(HistorialComidas registro);

	List<HistorialComidas> obtenerRegistroComidas(Long idPaciente);

}
