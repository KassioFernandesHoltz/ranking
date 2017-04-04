package br.com.ranking.principal;

import javax.swing.JOptionPane;

import br.com.ranking.GUI.MenuCadastroGUI;
import br.com.ranking.GUI.MenuCampeonatoGUI;
import br.com.ranking.enumeracoes.MenuPrincipal;
import br.com.ranking.util.RankingUtil;

public class Principal {

	public static void main(String[] args) {

		int op;		
		do {
			op = RankingUtil.escolhaMenu(MenuPrincipal.values(),"Opção");		

			switch (op) {
			case 0:// cadastros
				MenuCadastroGUI.executar();
				break;
			case 1:// campeonato
				MenuCampeonatoGUI.executar();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Fim do Programa", "",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Inválido",
						"Valor Inválido: " + op, JOptionPane.ERROR_MESSAGE);
				break;
			}
		} while (op != MenuPrincipal.values().length-1);

	}

}
