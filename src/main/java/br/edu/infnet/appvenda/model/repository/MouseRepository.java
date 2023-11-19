package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Mouse;

public interface MouseRepository extends CrudRepository<Mouse, Integer> {

	Mouse findByDescricao(String Descricao);
}
