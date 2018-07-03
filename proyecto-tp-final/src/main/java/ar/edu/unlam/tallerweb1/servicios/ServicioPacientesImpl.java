package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PacienteDao;
import ar.edu.unlam.tallerweb1.dao.PlanDao;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.PacienteDTO;
import ar.edu.unlam.tallerweb1.modelo.Plan;

@Service("servicioPacientes")
@Transactional
public class ServicioPacientesImpl implements ServicioPacientes {

	@Inject
	private PlanDao planDao;
	
	@Inject
	private PacienteDao pacienteDao;

	@Override
	public Plan consultarPlan (Long id) {
		return planDao.consultarPlan(id);
	}

	@Override
	public void insertarPlanesIniciales () {
		 planDao.insertarPlanesIniciales();
	}
	
	@Override
	public List<Plan> obtenerPlanesFiltrados(String intensidad, boolean aptoCeliaco, boolean aptoHipertenso, boolean sinCarne, boolean sinLacteos) {
		return planDao.obtenerPlanesFiltrados(intensidad, aptoCeliaco, aptoHipertenso, sinCarne, sinLacteos);
	}
	
	@Override
	public Plan generarPlanSugerido(PacienteDTO pacienteDTO) {
		return planDao.generarPlanSugerido(pacienteDTO);
	}
	
	@Override
	public void registrarPaciente(Paciente paciente){
		pacienteDao.savePacienteInBd(paciente);
	}
	
	@Override
	public Paciente obtenerPaciente(Long id){
		return pacienteDao.obtenerPaciente(id);
	}
}
