package br.com.ranking.GUI;


import br.com.ranking.enumeracoes.MenuCadastro;
import br.com.ranking.util.RankingUtil;

public class MenuCadastroGUI {

	public static void executar() {

		int op;
		CrudGuiImpl crudGuiImpl = new CrudGuiImpl();
		PaisGui pais = new PaisGui();
		EstadoGUI estado = new EstadoGUI();
		
		do {
			op = RankingUtil.escolhaMenu(MenuCadastro.values(),"Op��o");

			switch (op) {
			case 0:
				pais.executar("Pa�s");
				break;
			case 1:
				estado.executar("Estado");
				break;
			case 2:
				crudGuiImpl.executar("Cidade");
				break;
			case 3: 
				crudGuiImpl.executar("Clube");
				break;			
			}

		} while (op != MenuCadastro.values().length-1);

	}

}
