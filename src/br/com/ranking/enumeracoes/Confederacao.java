package br.com.ranking.enumeracoes;

public enum Confederacao {
	AFC(1),CAF(2),CONCACAF(3),CONMEBOL(4),OFC(5),UEFA(6);
	
	private int codigo;
	
	private Confederacao(int cod) {
		// TODO Auto-generated constructor stub
		this.codigo = cod;
	}

	public int getCodigo() {
		return codigo;
	}
		
	
}
