package ar.edu.unlam.tallerweb1.persistencia;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorProgresoPaciente;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Plan;
import ar.edu.unlam.tallerweb1.servicios.ServicioPacientes;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlan;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarPesoDiario;

import static org.assertj.core.api.Assertions.assertThat;

public class ControladorProgresoTestMock extends SpringTest {

	@Test @Rollback @Transactional
	public void testQuePruebaVerProgresoPaciente(){
		

		Plan planMock = mock(Plan.class);

		Paciente pacienteMock= mock(Paciente.class);
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		HttpSession sessionMock=mock(HttpSession.class);
		ServicioPlan servicioPlanMock= mock(ServicioPlan.class);
		ServicioPacientes servicioPacientesMock = mock(ServicioPacientes.class);
		ServicioRegistrarPesoDiario servicioRegistrarPesoMock = mock(ServicioRegistrarPesoDiario.class);
		
		ControladorProgresoPaciente miControlador = new ControladorProgresoPaciente();
		
		miControlador.setServicioPlan(servicioPlanMock);
		miControlador.setServicioPacientes(servicioPacientesMock);
		miControlador.setServicioRegistrarPesoDiario(servicioRegistrarPesoMock);
		
		when(servicioPacientesMock.obtenerPaciente(any())).thenReturn(pacienteMock);
		
		when(pacienteMock.getAltura()).thenReturn((double)170);
		when(pacienteMock.getSexo()).thenReturn("Hombre");
		when(pacienteMock.getPeso()).thenReturn((double)80);
		when(pacienteMock.getEdad()).thenReturn(30);
		when(pacienteMock.getEjercicio()).thenReturn(1);
		when(pacienteMock.getFecha_inicio()).thenReturn("19/07/2018");
			
		when(servicioPlanMock.consultarPlan(any())).thenReturn(planMock);
		when(planMock.getCaloriasDiarias()).thenReturn(1500);
		when(requestMock.getSession()).thenReturn(sessionMock);
		
		ModelAndView modelAndView = miControlador.verProgresoPaciente(pacienteMock, requestMock);

		assertThat(modelAndView.getViewName() ).isEqualTo("progresoPaciente");
			
	}
	
}
