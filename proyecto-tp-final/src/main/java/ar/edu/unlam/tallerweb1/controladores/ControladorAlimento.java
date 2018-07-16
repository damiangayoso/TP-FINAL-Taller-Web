package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlimentos;

@Controller
public class ControladorAlimento {
	@Inject
	private ServicioAlimentos servicioAlimentos;

	@RequestMapping(path = "/registrarConsumoAlimento", method = RequestMethod.GET)
	public ModelAndView irAregistrarConsumoAlimento() {
		
		ModelMap model = new ModelMap();
		
		model.put("alimentoDTO", new AlimentoDTO());
		
		List<Alimento> listadoAlimentos = servicioAlimentos.obtenerListadoDeAlimentos("comida");
		model.put("listadoAlimentos",listadoAlimentos);
		
		List<Alimento> listadoBebidas = servicioAlimentos.obtenerListadoDeAlimentos("bebida");
		model.put("listadoBebidas",listadoBebidas);
		
		return new ModelAndView("registrarConsumoAlimento", model);
	}
	
	@RequestMapping(path = "/ConsumoAlimento", method = RequestMethod.POST)
	public ModelAndView ConsumoAlimento(@ModelAttribute("alimentoDTO") AlimentoDTO alimentoDTO, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Alimento comida = servicioAlimentos.getAlimentoById(alimentoDTO.getComida().getId());
		model.put("comida",comida);
		Alimento bebida = servicioAlimentos.getAlimentoById(alimentoDTO.getBebida().getId());
		model.put("bebida",bebida);
		int cantComida=alimentoDTO.getCantComida();
		model.put("cantComida", cantComida);
		int cantBebida=alimentoDTO.getCantBebida();
		model.put("cantBebida", cantBebida);
		//System.out.println(newAlimento.getNombre() );
		
		return new ModelAndView("calorias", model);
	}
	
	@RequestMapping(path = "/cargarAlimentos", method = RequestMethod.GET)
	public ModelAndView cargarAlimentos() {

		Alimento alimento1 = new Alimento("yogur descremado con cereal",150,"comida");
		Alimento alimento2 = new Alimento("naranja",57,"comida" );
		Alimento alimento3 = new Alimento("plato de ensalada lechuga y tomate",200,"comida");
		Alimento alimento4 = new Alimento("2 mitades de tomate relleno con arroz integral, at�n, aceituna y 2 cdas. de mayonesa light",250,"comida");
		Alimento alimento5 = new Alimento("barrita de cereal light",94,"comida");
		Alimento alimento6 = new Alimento("figazza �rabe de salvado con queso fresco descremado y tomate",200,"comida");
		Alimento alimento7 = new Alimento("plato de verduras cocidas a elecci�n",150,"comida");
		Alimento alimento8 = new Alimento("milanesa de soja",200,"comida");
		Alimento alimento9 = new Alimento("porcion de gelatina diet con trozoz de fruta",30,"comida");
		Alimento alimento10 = new Alimento("filet de pescado a la plancha con limon",130,"comida");
		
		Alimento bebida1 = new Alimento("vaso grande de jugo light",50,"bebida");
		Alimento bebida2 = new Alimento("helado de agua",50,"bebida");
		Alimento bebida3 = new Alimento("latita de gaseosa light",1,"bebida");
		Alimento bebida4 = new Alimento("vaso de licuado de durazno con leche descremada",50,"bebida");
		Alimento bebida5 = new Alimento("vaso de ensalada de frutas",50,"bebida");
		Alimento bebida6 = new Alimento("licuado de melon y durazno con agua",50,"bebida");
		Alimento bebida7 = new Alimento("infucion con media taza de leche descremada",50,"bebida");
		Alimento bebida8 = new Alimento("taza de leche dscremada con 2 cdas de granola",50,"bebida");
		
		servicioAlimentos.guardarAlimento(alimento1);
		servicioAlimentos.guardarAlimento(alimento2);
		servicioAlimentos.guardarAlimento(alimento3);
		servicioAlimentos.guardarAlimento(alimento4);
		servicioAlimentos.guardarAlimento(alimento5);
		servicioAlimentos.guardarAlimento(alimento6);
		servicioAlimentos.guardarAlimento(alimento7);
		servicioAlimentos.guardarAlimento(alimento8);
		servicioAlimentos.guardarAlimento(alimento9);
		servicioAlimentos.guardarAlimento(alimento10);
		servicioAlimentos.guardarAlimento(bebida1);
		servicioAlimentos.guardarAlimento(bebida2);
		servicioAlimentos.guardarAlimento(bebida3);
		servicioAlimentos.guardarAlimento(bebida4);
		servicioAlimentos.guardarAlimento(bebida5);
		servicioAlimentos.guardarAlimento(bebida6);
		servicioAlimentos.guardarAlimento(bebida7);
		servicioAlimentos.guardarAlimento(bebida8);
			
		return new ModelAndView("redirect:/registrarConsumoAlimento");
	}
	
}
