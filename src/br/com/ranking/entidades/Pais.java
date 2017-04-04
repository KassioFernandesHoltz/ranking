package br.com.ranking.entidades;

import br.com.ranking.enumeracoes.Confederacao;
import br.com.ranking.enumeracoes.SimNao;

public class Pais {

	private int codigo;
	private String nome;
	private String sigla;
	private Confederacao confederacao;
	private SimNao apurarRanking;

	public Pais() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Confederacao getConfederacao() {
		return confederacao;
	}

	public void setConfederacao(Confederacao confederacao) {
		this.confederacao = confederacao;
	}

	public SimNao getApurarRanking() {
		return apurarRanking;
	}

	public void setApurarRanking(SimNao apurarRanking) {
		this.apurarRanking = apurarRanking;
	}

	@Override
	public String toString() {
		return nome;
	}

}
