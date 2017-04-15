package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.EstadoRN;
import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;
import br.com.ranking.util.RankingUtil;

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

			nome = RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog(null, "Informe o Nome", "Estado",
							JOptionPane.QUESTION_MESSAGE));

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
		Pais pais = new Pais();
		Pais favorito = paisRN.getFavorito();

		if (paises.length == 0) {
			JOptionPane.showMessageDialog(null,
					"É preciso cadastrar algum país", "",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// verifica se o país é favorito e atribui o primeiro pais como
			// sugestão
			if (favorito == null) {
				favorito = paises[0];
			}

			pais = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o Pais do qual desejar alterar o Estado", "País",
					JOptionPane.QUESTION_MESSAGE, null, paises, pais);

			Estado estados[] = estadoRN.itens(pais);

			if (estados.length == 0) {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum estado para o " + pais.getNome() , "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				estadoAux = (Estado) JOptionPane
						.showInputDialog(null, "Escolha o Estado", "Estado",
								JOptionPane.QUESTION_MESSAGE, null, estados,
								estados[0]);
				estadoAux.setNome(RankingUtil
						.PrimeiraLetraMaiuscula(JOptionPane.showInputDialog(
								"Altere o nome", estadoAux.getNome())));

				estadoAux.setSigla(JOptionPane.showInputDialog(
						"Altere a sigla", estadoAux.getSigla()).toUpperCase());

				estadoAux.setPais((Pais) JOptionPane.showInputDialog(null,
						"Escolha o Pais do qual desejar alterar o Estado",
						"País", JOptionPane.QUESTION_MESSAGE, null, paises,
						estadoAux.getPais()));

				estadoRN.atualizar(estadoAux);
			}

		}

	}

	public void listar() {

		EstadoRN estadoRN = new EstadoRN();
		PaisRN paisRN = new PaisRN();
		Pais pais = new Pais();
		Pais paises[] = paisRN.itens();
		String aux = "";

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
			pais = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o Pais do qual deseja-se listar os Estados",
					"País", JOptionPane.QUESTION_MESSAGE, null, paises, pais);

			Estado estados[] = estadoRN.itens(pais);

			for (Estado estado : estados) {
				aux += "Código: " + estado.getCodigo() + ", " + "Nome: "
						+ estado.getNome() + ", " + "Sigla: "
						+ estado.getSigla() + ", " + "País: "
						+ estado.getPais().getNome() + "\n";
			}

			JOptionPane.showMessageDialog(null, aux);
		}

	}

	public void excluir() {

		Estado estado = new Estado();
		EstadoRN estadoRN = new EstadoRN();
		PaisRN paisRN = new PaisRN();
		Pais pais = new Pais();
		Pais paises[] = paisRN.itens();
		Pais favorito = paisRN.getFavorito();

		if (paises.length == 0) {
			JOptionPane.showMessageDialog(null,
					"É preciso cadastrar algum país", "",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// verifica se o país é favorito e atribui o primeiro pais como
			// sugestão
			if (favorito == null) {
				favorito = paises[0];
			}
			pais = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o Pais do qual deseja-se escluir um Estado",
					"País", JOptionPane.QUESTION_MESSAGE, null, paises,
					favorito);
			Estado estados[] = estadoRN.itens(pais);

			if (estados.length == 0) {
				JOptionPane.showMessageDialog(null,
						"É preciso cadastrar algum estado para o " + pais.getNome(), "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				estado = (Estado) JOptionPane.showInputDialog(null,
						"Escolha o Estado", "Excluir",
						JOptionPane.DEFAULT_OPTION, null, estados, estados[0]);
				estadoRN.excluir(estado);
			}
		}

	}

}
