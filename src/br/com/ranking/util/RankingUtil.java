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
}
