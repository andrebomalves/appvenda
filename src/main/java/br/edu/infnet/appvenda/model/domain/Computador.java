package br.edu.infnet.appvenda.model.domain;

import javax.persistence.*;

@Entity
public class Computador extends Produto {

	private int quantidadeNucleos;
	private int quantidadePortasUsb;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %d", super.toString(), quantidadeNucleos, quantidadePortasUsb);
	}

	public int getQuantidadeNucleos() {
		return quantidadeNucleos;
	}

	public void setQuantidadeNucleos(int quantidadeNucleos) {
		this.quantidadeNucleos = quantidadeNucleos;
	}

	public int getQuantidadePortasUsb() {
		return quantidadePortasUsb;
	}

	public void setQuantidadePortasUsb(int quantidadePortasUsb) {
		this.quantidadePortasUsb = quantidadePortasUsb;
	}
	
}
