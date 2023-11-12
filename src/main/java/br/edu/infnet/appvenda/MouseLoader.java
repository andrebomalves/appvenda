package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Mouse;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.MouseService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Component
@Order(3)
public class MouseLoader implements ApplicationRunner {
	
	@Autowired
	private MouseService mouseService;
	@Autowired
	private VendedorService vendedorService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Vendedor> vendedores = (List<Vendedor>) vendedorService.obterLista();		
		Vendedor vendedor = !vendedores.isEmpty() ? vendedores.get(0) : null ;	
		
		List<String> linhas = Util.RecuperarLinhasDoArquivo("files/mouses.txt");
		
		linhas.forEach( linha -> {
			String[] campos = linha.split(";");
	
				Mouse mouse = new Mouse();
				mouse.setCodigo(Integer.valueOf(campos[0]));
				mouse.setDescricao(campos[1]);
				mouse.setEstoque(Boolean.valueOf(campos[2]));
				mouse.setPreco(Float.valueOf(campos[3]));
				mouse.setSemFio(Boolean.valueOf(campos[4]));
				mouse.setQuantidadeDeBotoes(Integer.valueOf(campos[5]));
				mouse.setVendedor(vendedor);
				
				try {
					mouseService.incluir(mouse);					
				} catch (Exception e) {
					System.out.println("Erro ao incluir o mouse " + mouse);
				}

				
		});
		
		for(Mouse mouse : mouseService.obterLista()) {
			System.out.println("Mouse: " + mouse);
		}
	}
	
	
}
