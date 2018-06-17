package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.*;

public interface PacienteDao {
	
//	este metodo retorna el objeto paciente por medio de un Long id
	Paciente getPacienteById(Long id);
//	este metodo guarda en BD el objeto Paciente enviado por parametro y retorna su id
	Long savePacienteInBd (Paciente paciente);
//	este metodo retorna el peso de un paciente desde la BD
	Double getPesoPaciente(Long id);
}