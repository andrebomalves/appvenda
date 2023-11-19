package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.domain.Mouse;
import br.edu.infnet.appvenda.model.service.MouseService;

@Controller
public class MouseController {
	@Autowired
	private MouseService mouseService;
	@Autowired
	private AppController appController;	

	@GetMapping(value = "/mouse/{id}/excluir")
	public String excluirMouse(@PathVariable Integer id) {
		
		mouseService.excluir(id);
		
		return "redirect:/mouse/lista";
	}
	
	@GetMapping(value = "/mouse/pesquisar")
	public String pesquisar(Model model, String campoBusca) {

		Mouse mouse = mouseService.pesquisar(campoBusca);
		
		if(mouse != null) {
			model.addAttribute("objeto", mouse);
			return appController.showHome(model);
		}
		return "redirect:/mouse/lista";
	}
	
}
