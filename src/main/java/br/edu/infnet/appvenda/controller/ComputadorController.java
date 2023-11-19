package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.domain.Computador;
import br.edu.infnet.appvenda.model.service.ComputadorService;

@Controller
public class ComputadorController {	
	@Autowired
	private ComputadorService computadorService;
	@Autowired
	private AppController appController;	

	@GetMapping(value = "/computador/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		computadorService.excluir(id);
		
		return "redirect:/computador/lista";
	}
	
	@GetMapping(value = "/computador/pesquisar")
	public String pesquisar(Model model, String campoBusca) {

		Computador computador = computadorService.pesquisar(campoBusca);
		
		if(computador != null) {
			model.addAttribute("objeto", computador);
			return appController.showHome(model);
		}
		return "redirect:/computador/lista";
	}
	
}
