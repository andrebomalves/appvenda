package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Computador;
import br.edu.infnet.appvenda.model.service.ComputadorService;

@Component
public class ComputadorLoader implements ApplicationRunner {
	
	@Autowired
	private ComputadorService computadorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<String> linhas = Util.RecuperarLinhasDoArquivo("files/computadores.txt");
		
		linhas.forEach( linha -> {
			String[] campos = linha.split(";");
	
			Computador computador = new Computador();
			computador.setCodigo(Integer.valueOf(campos[0]));
			computador.setDescricao(campos[1]);
			computador.setEstoque(Boolean.valueOf(campos[2]));
			computador.setPreco(Float.valueOf(campos[3]));
			computador.setQuantidadeNucleos(Integer.valueOf(campos[4]));
			computador.setQuantidadePortasUsb(Integer.valueOf(campos[5]));
				
			computadorService.incluir(computador);

				
		});
		
		for(Computador computador : computadorService.obterLista()) {
			System.out.println("Computador: " + computador);
		}
	}
	
	
}
