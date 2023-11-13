package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Mouse;
import br.edu.infnet.appvenda.model.repository.MouseRepository;

@Service
public class MouseService {
	
	@Autowired
	private MouseRepository mouseRepository;

	public void incluir(Mouse mouse) {
		mouseRepository.save(mouse);
	}
	
	public Collection<Mouse> obterLista(){	
		return (Collection<Mouse>) mouseRepository.findAll();
	}
	
	public long obterQtde() {
		return mouseRepository.count();
	}
	
	public void excluir(Integer id) {
		mouseRepository.deleteById(id);
	}
}
