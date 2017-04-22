package br.com.ranking.GUI;


import br.com.ranking.enumeracoes.MenuCadastro;
import br.com.ranking.util.RankingUtil;

public class MenuCadastroGUI {

	public static void executar() {

		int op;
		CrudGuiImpl crudGuiImpl = new CrudGuiImpl();
		PaisGui pais = new PaisGui();
		EstadoGUI estado = new EstadoGUI();
		CidadeGUI cidade = new CidadeGUI();
		ClubeGUI clube = new ClubeGUI();
		
		do {
			op = RankingUtil.escolhaMenu(MenuCadastro.values(),"Opção");

			switch (op) {
			case 0:
				pais.executar("País");
				break;
			case 1:
				estado.executar("Estado");
				break;
			case 2:
				cidade.executar("Cidade");
				break;
			case 3: 
				clube.executar("Clube");
				break;			
			}

		} while (op != MenuCadastro.values().length-1);

	}

}
