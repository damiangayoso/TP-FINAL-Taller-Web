package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorAlimento;
import ar.edu.unlam.tallerweb1.modelo.Alimento;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlimentos;

public class ControladorAlimentoTestMock extends SpringTest{

	@Test @Rollback @Transactional
	public void testQuePruebairAregistrarConsumoAlimento(){
		
		ControladorAlimento miControlador=new ControladorAlimento();
		ServicioAlimentos servicioAlimentosMock=mock(ServicioAlimentos.class);
		miControlador.setServicioAlimentos(servicioAlimentosMock);
		
		List<Alimento> listadoAlimentos =mock(List.class);
		List<Alimento> listadoBebidas =mock(List.class);
		
		when(servicioAlimentosMock.obtenerListadoDeAlimentos("comida") ).thenReturn(listadoAlimentos);
		when(servicioAlimentosMock.obtenerListadoDeAlimentos("bebida") ).thenReturn(listadoBebidas);
		

		ModelAndView modelAndView = miControlador.irAregistrarConsumoAlimento();

		assertThat(modelAndView.getViewName() ).isEqualTo("registrarConsumoAlimento");
		
	}
	
}
