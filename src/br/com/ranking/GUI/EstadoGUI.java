package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.EstadoRN;
import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;

public class EstadoGUI extends CrudGuiImpl {

	public void incluir() {
		Estado estadoAux = new Estado();
		EstadoRN estadoRN = new EstadoRN();
		PaisRN paisRN = new PaisRN();
		Pais paises[] = paisRN.itens();
		Pais favorito = paisRN.getFavorito();

		// verifica se o país é favorito e atribui o primeiro pais como sugestão
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

			String nome;
			String sigla;
			Pais pais = new Pais();

			nome = JOptionPane.showInputDialog(null, "Informe o Nome",
					"Estado", JOptionPane.QUESTION_MESSAGE);

			sigla = JOptionPane.showInputDialog(null, "Informe a Sigla",
					"Sigla", JOptionPane.QUESTION_MESSAGE);

			pais = (Pais) JOptionPane.showInputDialog(null, "Escolha o País",
					"País", JOptionPane.QUESTION_MESSAGE, null, paises,
					favorito);

			estadoAux.setNome(nome);
			estadoAux.setSigla(sigla.toUpperCase());
			estadoAux.setPais(pais);

			estadoRN.incluir(estadoAux);
		}

	}

	public void alterar() {

		Estado estadoAux = new Estado();
		EstadoRN estadoRN = new EstadoRN();
		PaisRN paisRN = new PaisRN();
		Pais paises[] = paisRN.itens();
		Pais paisAux = new Pais();

		paisAux = (Pais) JOptionPane.showInputDialog(null,
				"Escolha o Pais do qual desejar alterar o Estado", "País",
				JOptionPane.QUESTION_MESSAGE, null, paises, paises[0]);

		Estado estados[] = estadoRN.itens(paisAux.getCodigo());

		estadoAux = (Estado) JOptionPane.showInputDialog(null,
				"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
				null, estados, estados[0]);

		estadoAux.setNome(JOptionPane.showInputDialog("Altere o nome",
				estadoAux.getNome()));

		estadoAux.setSigla(JOptionPane.showInputDialog("Altere a sigla",
				estadoAux.getSigla()).toUpperCase());

		estadoAux
				.setPais((Pais) JOptionPane.showInputDialog(null,
						"Escolha o Pais do qual desejar alterar o Estado",
						"País", JOptionPane.QUESTION_MESSAGE, null, paises,
						estadoAux.getPais()));

		estadoRN.atualizar(estadoAux);

	}

}
