package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.MouseService;

@Controller
public class MouseController {
	@Autowired
	private MouseService mouseService;


	@GetMapping(value = "/mouse/{id}/excluir")
	public String excluirMouse(@PathVariable Integer id) {
		
		mouseService.excluir(id);
		
		return "redirect:/mouse/lista";
	}
	
}
