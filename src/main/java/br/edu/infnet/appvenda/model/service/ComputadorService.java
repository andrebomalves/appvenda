package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Computador;

@Service
public class ComputadorService {

	private Map<Integer, Computador> mapaComputador = new HashMap<Integer, Computador>();

	public void incluir(Computador computador) {
		mapaComputador.put(computador.getCodigo(), computador);
	}
	
	public Collection<Computador> obterLista(){	
		return mapaComputador.values();
	}
}
