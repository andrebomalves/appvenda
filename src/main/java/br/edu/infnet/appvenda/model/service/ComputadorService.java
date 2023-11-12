package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Computador;
import br.edu.infnet.appvenda.model.repository.ComputadorRepository;

@Service
public class ComputadorService {

	@Autowired
	private ComputadorRepository computadorRepository;

	public void incluir(Computador computador) {
		computadorRepository.save(computador);
	}
	
	public Collection<Computador> obterLista(){	
		return (Collection<Computador>) computadorRepository.findAll();
	}
	
	public long obterQtde() {
		return computadorRepository.count();
	}
	
	public void excluir(Integer id) {
		computadorRepository.deleteById(id);
	}
}
