package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/")
	public String ShowHome(Model model) {
		
		model.addAttribute("listagem",vendedorService.obterLista());
		System.out.println("passei pela controller");
		return "home";
	}
	
}
