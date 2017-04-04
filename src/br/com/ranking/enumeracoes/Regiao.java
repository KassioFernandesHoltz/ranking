package br.com.ranking.enumeracoes;

public enum Regiao {
	
	Estadual(1),Regional(2),Nacional(3),Continental(4),Mundial(5);
	
	private int codigo;
	
	private Regiao(int cod) {
		// TODO Auto-generated constructor stub
		this.codigo = cod;
	}

	public int getCodigo() {
		return codigo;
	}
			
}
