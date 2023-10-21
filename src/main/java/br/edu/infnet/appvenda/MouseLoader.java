package br.edu.infnet.appvenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Mouse;
import br.edu.infnet.appvenda.model.service.MouseService;

@Component
public class MouseLoader implements ApplicationRunner {
	
	@Autowired
	private MouseService mouseService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
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
				
				mouseService.incluir(mouse);

				
		});
		
		for(Mouse mouse : mouseService.obterLista()) {
			System.out.println("Mouse: " + mouse);
		}
	}
	
	
}
