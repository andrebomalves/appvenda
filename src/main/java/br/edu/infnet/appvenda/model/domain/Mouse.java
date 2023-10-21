package br.edu.infnet.appvenda.model.domain;

public class Mouse extends Produto {
	
	private boolean semFio;
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
