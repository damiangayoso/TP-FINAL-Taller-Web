package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPacientes;

public class ControladorLoginTestMock extends SpringTest{
	
	@Test @Rollback @Transactional
	public void testQuePruebaValidarLogin(){
		
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		ServicioPacientes servicioPacientesMock = mock(ServicioPacientes.class);
		HttpServletRequest requestMock=mock(HttpServletRequest.class);
		HttpSession sessionMock=mock(HttpSession.class);
		ControladorLogin miControlador = new ControladorLogin();
		List<Paciente> pacientesMock = mock(List.class);
		
		miControlador.setServicioLogin(servicioLoginMock);
		miControlador.setServicioPacientes(servicioPacientesMock);
				
		Usuario usuarioMock = mock(Usuario.class);
		
		when(usuarioMock.getId()).thenReturn((long)1);
		when(usuarioMock.getNombre()).thenReturn("MockNombre");
		when(usuarioMock.getApellido()).thenReturn("MockApellido");
		when(usuarioMock.getEmail()).thenReturn("Mock@email.com");
		
		when(requestMock.getSession()).thenReturn(sessionMock);
		
		when(servicioLoginMock.consultarUsuario(any(Usuario.class))).thenReturn(usuarioMock);
		when(servicioPacientesMock.obtenerListadoPacientes()).thenReturn(pacientesMock);
		
		ModelAndView modelAndView = miControlador.validarLogin(usuarioMock, requestMock);

		assertThat(modelAndView.getViewName() ).isEqualTo("home");
	}
}
