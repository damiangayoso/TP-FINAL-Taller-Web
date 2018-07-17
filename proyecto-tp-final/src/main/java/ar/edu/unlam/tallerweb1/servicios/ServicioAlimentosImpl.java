package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AlimentoDao;
import ar.edu.unlam.tallerweb1.modelo.*;

@Service("servicioAlimentos")
@Transactional
public class ServicioAlimentosImpl implements ServicioAlimentos{

	@Inject
	private AlimentoDao alimentoDao;
	
	@Override
	public List<Alimento> obtenerListadoDeAlimentos(){
		return alimentoDao.obtenerListadoDeAlimentos();
	}

	@Override
	public List<Alimento> obtenerListadoDeAlimentos(String tipo) {
		return alimentoDao.obtenerListadoDeAlimentos(tipo);
	}
	
	@Override
	public void guardarAlimento(Alimento alimento){
		alimentoDao.guardarAlimento(alimento);
	}
	
	@Override
	public Alimento getAlimentoById(Long id){
		return alimentoDao.getAlimentoById(id);
	}
	
	@Override
	public void guardarRegistroComida(HistorialComidas registro) {
		alimentoDao.guardarRegistroComida(registro);	
	}
	
	@Override
	public List<HistorialComidas> obtenerRegistroComidas(Long idPaciente) {
		return alimentoDao.obtenerRegistroComidas(idPaciente);	
	}
	
}
