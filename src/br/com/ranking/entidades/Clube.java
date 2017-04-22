package br.com.ranking.entidades;

public class Clube {
	
	private int codigo;
	private String nome;
	private Cidade cidade;
	
	public Clube(){
		
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return nome + "-" + cidade.getEstado().getSigla();
	}
	
	
	
}
