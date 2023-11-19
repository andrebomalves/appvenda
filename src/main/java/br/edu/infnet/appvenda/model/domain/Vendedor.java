package br.edu.infnet.appvenda.model.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "vendedores")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, max = 50)
	private String nome;
	
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
	@Column(unique = true)
	private String cpf;
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String email;
	
	@OneToMany(
            mappedBy = "vendedor",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true
    )
	private List<Produto> produtos;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@Override
	public String toString() {
		return String.format("id (%d) - nome (%s) - cpf (%s) - email (%s) - endereco (%s) - produtos (%d)", id, nome, cpf, email, endereco,produtos != null ? produtos.size() : 0);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
