package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.CidadeRN;
import br.com.ranking.RN.EstadoRN;
import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Cidade;
import br.com.ranking.entidades.Pais;
import br.com.ranking.entidades.Estado;
import br.com.ranking.util.RankingUtil;

public class CidadeGUI extends CrudGuiImpl {

	public void incluir() {
		PaisRN paisRN = new PaisRN();
		EstadoRN estadoRN = new EstadoRN();
		CidadeRN cidadeRN = new CidadeRN();
		Pais favorito = paisRN.getFavorito();
		Estado estado = new Estado();
		String nome;
		Cidade cidade = new Cidade();

		// selecionar o país
		Pais paises[] = paisRN.itens();

		if (favorito == null) {
			if (paises.length != 0) {
				favorito = paises[0];
			} else {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum país", "",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (favorito != null) {
			favorito = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o País da cidade", "País",
					JOptionPane.QUESTION_MESSAGE, null, paises, favorito);

			Estado estados[] = estadoRN.itens(favorito);

			if (estados.length == 0) {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum estado", "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				estado = (Estado) JOptionPane
						.showInputDialog(null, "Escolha o Estado", "Estado",
								JOptionPane.QUESTION_MESSAGE, null, estados,
								estados[0]);
				nome = RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
						.showInputDialog(null, "Informe o nome da cidade", "Cidade",
								JOptionPane.QUESTION_MESSAGE));
				cidade.setEstado(estado);
				cidade.setNome(nome);
				cidadeRN.incluir(cidade);
			}
		}

	}
	
	public void alterar(){
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		EstadoRN estadoRN = new EstadoRN();
		PaisRN paisRN = new PaisRN();
		CidadeRN cidadeRN = new CidadeRN();
		Pais favorito = paisRN.getFavorito();
		Pais paises[] = paisRN.itens();
		
		if (favorito == null) {
			if (paises.length != 0) {
				favorito = paises[0];
			} else {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum país", "",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		
		if (favorito != null) {
			favorito = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o País da cidade", "País",
					JOptionPane.QUESTION_MESSAGE, null, paises, favorito);
			Estado estados[] = estadoRN.itens(favorito);
			if (estados.length == 0) {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum estado", "",
						JOptionPane.ERROR_MESSAGE);
			}else{
				estado = (Estado) JOptionPane
						.showInputDialog(null, "Escolha o Estado", "Estado",
								JOptionPane.QUESTION_MESSAGE, null, estados,
								estados[0]);
				Cidade cidades[] = cidadeRN.itens(estado);
				cidade = (Cidade) JOptionPane
						.showInputDialog(null, "Escolha o Estado", "Estado",
								JOptionPane.QUESTION_MESSAGE, null, cidades,
								cidades[0]);
				cidade.setNome(RankingUtil
						.PrimeiraLetraMaiuscula(JOptionPane.showInputDialog(
								"Altere o nome", cidade.getNome())));
				cidade.setEstado((Estado)JOptionPane.showInputDialog(null, "Escolha o Estado", "Estado", 
						JOptionPane.QUESTION_MESSAGE, null, estados, cidade.getEstado()));

			}
		}
		
	}
	
}
