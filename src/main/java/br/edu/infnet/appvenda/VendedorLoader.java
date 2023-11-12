package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Component
@Order(1)
public class VendedorLoader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<String> linhas = Util.RecuperarLinhasDoArquivo("files/vendedores.txt");
		
		linhas.forEach( linha -> {
			String[] campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setCpf(campos[1]);
			vendedor.setEmail(campos[2]);
			vendedor.setNome(campos[0]);
			vendedor.setEndereco(new Endereco(campos[3]));
			
			vendedorService.incluir(vendedor);
			System.out.println("Vendedor: "+ vendedor);
		});
	}
	
	
}
