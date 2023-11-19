package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.appvenda.model.domain.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

	@Query("select v from #{#entityName} v inner join fetch v.produtos order by v.id ")
	List<Vendedor> findAllVendedorByProduto();
	
	List<Vendedor> findAll(Sort sort);
	
	Vendedor findByCpf(String cpf);
}
