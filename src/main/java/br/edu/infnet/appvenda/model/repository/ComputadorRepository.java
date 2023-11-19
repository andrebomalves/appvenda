package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Computador;

@Repository
public interface ComputadorRepository extends CrudRepository<Computador, Integer> {

	Computador findByDescricao(String Descricao);
}
