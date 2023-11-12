package br.edu.infnet.appvenda.controller;

import java.awt.Component;

import javax.swing.event.MenuDragMouseEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.MouseService;
import br.edu.infnet.appvenda.model.service.ComputadorService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private MouseService mouseService;
	@Autowired
	private ComputadorService computadorService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeMouse", mouseService.obterQtde());
		model.addAttribute("qtdeComputador", computadorService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		model.addAttribute("rota", "produto");
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/mouse/lista")
	public String obterListaAlimenticio(Model model) {
		model.addAttribute("rota", "mouse");
		model.addAttribute("titulo", "Produtos Alimentícios:");
		model.addAttribute("listagem", mouseService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/computador/lista")
	public String obterListaEletronico(Model model) {
		model.addAttribute("rota", "computador");
		model.addAttribute("titulo", "Produtos Eletrônicos:");
		model.addAttribute("listagem", computadorService.obterLista());

		return showHome(model);
	}
	
	@GetMapping(value = "/produto/{id}/excluir")
	public String excluirProduto(@PathVariable Integer id) {
		
		produtoService.excluir(id);
		
		return "redirect:/produto/lista";
	}
	
	@GetMapping(value = "/mouse/{id}/excluir")
	public String excluirMouse(@PathVariable Integer id) {
		
		mouseService.excluir(id);
		
		return "redirect:/mouse/lista";
	}
	
	@GetMapping(value = "/computador/{id}/excluir")
	public String excluirComputador(@PathVariable Integer id) {
		
		computadorService.excluir(id);
		
		return "redirect:/computador/lista";
	}
}