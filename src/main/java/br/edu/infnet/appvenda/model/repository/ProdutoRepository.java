package br.edu.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
