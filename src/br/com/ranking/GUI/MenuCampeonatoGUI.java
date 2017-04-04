package br.com.ranking.GUI;


import br.com.ranking.enumeracoes.MenuCampeonato;
import br.com.ranking.util.RankingUtil;

public class MenuCampeonatoGUI {

	public static void executar() {

		int op;
		CrudGuiImpl crudGuiImpl = new CrudGuiImpl();		
		
		do {
			op = RankingUtil.escolhaMenu(MenuCampeonato.values(), "Opção");

			switch (op) {
			case 0:
				crudGuiImpl.executar("Campeonato");
				break;
			case 1:
				crudGuiImpl.executar("Temporada");
				break;
			case 2:
				ParticipanteGUI.executar();
				break;
			case 3:
				RodadaGui.executar();
				break;
			case 4:
				crudGuiImpl.executar("Jogo");
				break;
			}

		} while (op != MenuCampeonato.values().length - 1);

	}

}
