package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.ComputadorService;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import br.edu.infnet.appvenda.model.service.MouseService;
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
	@Autowired
	private InformacaoService informacaoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("informacoes", informacaoService.obterLista());
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
		
}