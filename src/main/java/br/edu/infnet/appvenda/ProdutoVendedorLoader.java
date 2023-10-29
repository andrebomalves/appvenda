package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Component
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
		
		
		/*
		linhas.forEach( linha -> {
			String[] campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
			vendedor.setNome(campos[0]);
			
			vendedorService.incluir(vendedor);
			System.out.println("Vendedor: "+ vendedor);
		});
		*/
	}
	
	
}
