package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Computador;
import br.edu.infnet.appvenda.model.domain.Mouse;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Component
@Order(2)
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Vendedor> vendedores = (List<Vendedor>) vendedorService.obterLista();
		
		Vendedor vendedor = !vendedores.isEmpty() ? vendedores.get(0) : null ;
		
		List<String> linhas = Util.RecuperarLinhasDoArquivo("files/produtos.txt");
		
		
		
		linhas.forEach( linha -> {
			String[] campos = linha.split(";");
			
			switch (campos[6]) {
			case "M":
				Mouse mouse = new Mouse();
				mouse.setCodigo(Integer.valueOf(campos[0]));
				mouse.setDescricao(campos[1]);
				mouse.setEstoque(Boolean.valueOf(campos[2]));
				mouse.setPreco(Float.valueOf(campos[3]));
				mouse.setSemFio(Boolean.valueOf(campos[4]));
				mouse.setQuantidadeDeBotoes(Integer.valueOf(campos[5]));
				mouse.setVendedor(vendedor);
				
				produtoService.incluir(mouse);
				
				break;

			case "C":
				Computador computador = new Computador();
				computador.setCodigo(Integer.valueOf(campos[0]));
				computador.setDescricao(campos[1]);
				computador.setEstoque(Boolean.valueOf(campos[2]));
				computador.setPreco(Float.valueOf(campos[3]));
				computador.setQuantidadeNucleos(Integer.valueOf(campos[4]));
				computador.setQuantidadePortasUsb(Integer.valueOf(campos[5]));
				computador.setVendedor(vendedor);
				
				produtoService.incluir(computador);
				
				break;

			default:
				break;
			}
		});
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("Produto: " + produto);			
		}
	}
	
	
}
