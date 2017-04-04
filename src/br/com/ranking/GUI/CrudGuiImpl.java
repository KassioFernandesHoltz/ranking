package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.enumeracoes.MenuCRUD;
import br.com.ranking.util.RankingUtil;

public class CrudGuiImpl implements CrudGUI {
	
	protected void executar(String titulo) {
		// TODO Auto-generated method stub
		int op;
		 
		do{
			
			op = RankingUtil.escolhaMenu(MenuCRUD.values(), titulo);
			
			switch (op) {
			case 0:
				incluir();
				break;
			case 1:
				alterar();
				break;
			case 2:
				listar();
				break;
			case 3:
				excluir();
				break;
			}
			
		}while(op != MenuCRUD.values().length-1);
		
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Incluir em construção");

	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Alterar em construção");
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Listar em construção");
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Excluir em construção");
	}

}
