package br.com.ranking.enumeracoes;

public enum SimNao {
	Sim('S'),Nao('N');
	
	private char resposta;
	
	private SimNao(char resp) {
		// TODO Auto-generated constructor stub
		this.resposta = resp;
	}

	public char getResposta() {
		return resposta;
	}
		
	
}
