package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.ComputadorService;

@Controller
public class ComputadorController {	
	@Autowired
	private ComputadorService computadorService;


	@GetMapping(value = "/computador/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		computadorService.excluir(id);
		
		return "redirect:/computador/lista";
	}
	
}
