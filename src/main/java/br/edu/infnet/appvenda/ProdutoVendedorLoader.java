package br.edu.infnet.appvenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

import br.edu.infnet.appvenda.model.service.VendedorService;

//@Component
@Order(5)
public class ProdutoVendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		var vendedores = vendedorService.obterListaProduto();
		
		vendedores.forEach(linha -> {
			
			System.out.println("Vendedor: " + linha.toString());
			
			linha.getProdutos().forEach(prod -> {
				System.out.println("Produto: "+ prod.toString());
			});
			
			System.out.println("***********************************");
			
			
		});
		
	}
	
	
}
