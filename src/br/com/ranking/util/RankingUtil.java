package br.com.ranking.util;

import javax.swing.JOptionPane;

public class RankingUtil {

	public static int escolhaMenu(Object opcoes[], String titulo) {
		int op;

		op = JOptionPane.showOptionDialog(null, "Escolha uma opção", titulo,
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, opcoes, opcoes[opcoes.length - 1]);
		return op;
	}
	
	public static String PrimeiraLetraMaiuscula(String nome){
		String aux = "", anterior,atual;
		nome = nome.toLowerCase();
		nome = nome.trim();
		anterior =""+nome.charAt(0); 
		aux =""+nome.charAt(0);
		aux = aux.toUpperCase();
		for(int i = 1; i<nome.length(); i++){
			atual = "" + nome.charAt(i);
			if( anterior.equals(" ") ){
				atual = atual.toUpperCase();
			}
			anterior = atual;
			aux+=atual;
		}
		return aux;
	}
	
}
