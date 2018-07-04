package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.RegistrarPesoDiarioDTO;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarPesoDiario;

@Controller
public class ControladorRegistrarPesoDiario {
	@Inject
	private ServicioRegistrarPesoDiario servicioRegistrarPesoDiario;

	@RequestMapping(path = "/registrarPesoDiario", method = RequestMethod.GET)
	public ModelAndView irARegistroPesoDiario() {
		ModelMap model = new ModelMap();
		RegistrarPesoDiarioDTO registrarPesoDiarioDTO = new RegistrarPesoDiarioDTO();
		model.put("registrarPesoDiarioDTO",registrarPesoDiarioDTO);
		
		return new ModelAndView("registrarPesoDiario", model);
	}
	
	@RequestMapping(path = "/completarRegistroPesoDiario", method = RequestMethod.POST)
	public ModelAndView darAltaRegistroPeso(@ModelAttribute("registrarPesoDiarioDTO") RegistrarPesoDiarioDTO registrarPesoDiarioDTO, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		//tomo la fecha actual junto con el id del usuario y busco si ya existe un registro
		//cambiar el dummy id por el id del user en session
		
		Long longId = (Long) request.getSession().getAttribute("ID");
		int id = longId.intValue();
		
		
		Date fecha = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String f = dateFormat.format(fecha);
		
		RegistrarPesoDiarioDTO registroBuscado = servicioRegistrarPesoDiario.ConsultarRegistroFecha(id, f);
		
		if(registroBuscado != null) {
			// si ya existe registro ese dia se le avisa que no puede ingresarlo nuevamente

			model.put("error", "Ya existe un registro en la fecha actual, vuelva ma�ana para ingresar un nuevo registro.");
			return new ModelAndView("registrarPesoDiario", model);
		}
		else {
			// si no existe registro en esta fecha procedemos a guardarlo en la base de datos

			registrarPesoDiarioDTO.setFecha(f);
			registrarPesoDiarioDTO.setIdPaciente(longId);
			servicioRegistrarPesoDiario.RegistrarPesoDiario(registrarPesoDiarioDTO);
			return new ModelAndView("completarRegistroPesoDiario", model);
		}
			
	}
	
	@RequestMapping(path = "/cargarDatosRoot", method = RequestMethod.GET)
	public ModelAndView cargarDatosRoot(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("05/07/2018",(float)80,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("06/07/2018",(float)77,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("07/07/2018",(float)77,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("08/07/2018",(float)75,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("09/07/2018",(float)74,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("10/07/2018",(float)73,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("11/07/2018",(float)73,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("12/07/2018",(float)72,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("13/07/2018",(float)71,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("14/07/2018",(float)70,(long)1));
		servicioRegistrarPesoDiario.RegistrarPesoDiario(new RegistrarPesoDiarioDTO("15/07/2018",(float)70,(long)1));
		
		return new ModelAndView("home", model);
	}
	
}
