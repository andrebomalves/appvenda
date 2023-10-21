package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Mouse;

@Service
public class MouseService {

	private Map<Integer, Mouse> mapaMouse = new HashMap<Integer, Mouse>();

	public void incluir(Mouse mouse) {
		mapaMouse.put(mouse.getCodigo(), mouse);
	}
	
	public Collection<Mouse> obterLista(){	
		return mapaMouse.values();
	}
}
