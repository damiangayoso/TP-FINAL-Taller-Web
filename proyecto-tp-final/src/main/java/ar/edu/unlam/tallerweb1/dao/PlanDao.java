package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PacienteDTO;
import ar.edu.unlam.tallerweb1.modelo.Plan;

// Interface que define los metodos del DAO de Plan.
public interface PlanDao {
	
	// M�todo para obtener los datos de un plan mediante el ID.
	Plan consultarPlan (Long id);
	
	// M�todo para insertar los planes al levantar la aplicaci�n. Se usa para poder probar la aplicaci�n. Cuando se desarrolle el ABM de planes, este se va a borrar.
	void insertarPlanesIniciales();

	// M�todo para obtener los planes recomendados en base a las opciones escogidas.
	List<Plan> obtenerPlanesFiltrados(String intensidad, boolean aptoCeliaco, boolean aptoHipertenso, boolean sinCarne, boolean sinLacteos);

	Plan generarPlanSugerido(PacienteDTO pacienteDTO);
}
