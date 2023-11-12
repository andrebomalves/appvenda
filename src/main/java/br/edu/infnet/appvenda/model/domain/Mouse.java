package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Mouse extends Produto {
	
	private boolean semFio;
	@PositiveOrZero
	private int quantidadeDeBotoes;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), semFio, quantidadeDeBotoes);
	}

	public boolean isSemFio() {
		return semFio;
	}

	public void setSemFio(boolean semFio) {
		this.semFio = semFio;
	}

	public int getQuantidadeDeBotoes() {
		return quantidadeDeBotoes;
	}

	public void setQuantidadeDeBotoes(int quantidadeDeBotoes) {
		this.quantidadeDeBotoes = quantidadeDeBotoes;
	}	
	
}
