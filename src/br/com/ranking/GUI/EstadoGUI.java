package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.EstadoRN;
import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;
import br.com.ranking.util.RankingUtil;

public class EstadoGUI extends CrudGuiImpl {

	EstadoRN estadoRN = new EstadoRN();
	PaisRN paisRN = new PaisRN();
	private Pais favorito;
	private Pais pais = new Pais();
	private Estado estado = new Estado();

	public void incluir() {

		Estado estadoAux = new Estado();

		if (verificaPaises()) {

			String nome;
			String sigla;
			// Pais pais = new Pais();

			nome = RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog(null, "Informe o Nome", "Estado",
							JOptionPane.QUESTION_MESSAGE));

			sigla = JOptionPane.showInputDialog(null, "Informe a Sigla",
					"Sigla", JOptionPane.QUESTION_MESSAGE);

			pais = (Pais) JOptionPane.showInputDialog(null, "Escolha o País",
					"País", JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					favorito);

			estadoAux.setNome(nome);
			estadoAux.setSigla(sigla.toUpperCase());
			estadoAux.setPais(pais);

			estadoRN.incluir(estadoAux);
		}

	}

	public void alterar() {

		Estado estadoAux = new Estado();
		// Pais paises[] = paisRN.itens();
		// Pais pais = new Pais();

		if (verificaEstado("Escolha o Pais do qual desejar alterar o Estado")) {
			estadoAux = (Estado) JOptionPane.showInputDialog(null,
					"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
					null, estadoRN.itens(pais), estado);
			estadoAux.setNome(RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog("Altere o nome", estadoAux.getNome())));

			estadoAux.setSigla(JOptionPane.showInputDialog("Altere a sigla",
					estadoAux.getSigla()).toUpperCase());

			estadoAux.setPais((Pais) JOptionPane.showInputDialog(null,
					"Escolha o Pais do qual desejar alterar o Estado", "País",
					JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					estadoAux.getPais()));
			estadoRN.atualizar(estadoAux);

		}

	}

	public void listar() {

		String aux = "";

		// Pais favorito = paisRN.getFavorito();

		if (verificaPaises()) {

			pais = (Pais) JOptionPane.showInputDialog(null, "Escolha o País",
					"País", JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					favorito);

			for (Estado estado : estadoRN.itens(pais)) {
				aux += "Código: " + estado.getCodigo() + ", " + "Nome: "
						+ estado.getNome() + ", " + "Sigla: "
						+ estado.getSigla() + ", " + "País: "
						+ estado.getPais().getNome() + "\n";
			}

			JOptionPane.showMessageDialog(null, aux);
		}

	}

	public void excluir() {

		if (verificaEstado("Escolha o Pais do qual desejar excluir o Estado")) {
			Estado estadoAux = new Estado();
			estadoAux = (Estado) JOptionPane.showInputDialog(null,
					"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
					null, estadoRN.itens(pais), estado);
			estadoRN.excluir(estadoAux);
		}

	}

	private boolean verificaPaises() {
		favorito = paisRN.getFavorito();
		boolean resultado = true;
		Pais paises[] = paisRN.itens();
		if (paises.length == 0) {
			resultado = false;
			JOptionPane.showMessageDialog(null,
					"É preciso cadastrar algum país", "",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (favorito == null) {
				favorito = paises[0];
			}

		}

		return resultado;
	}

	private boolean verificaEstado(String mensagem) {

		boolean resultado = true;

		if (!verificaPaises()) {
			return false;
		} else {
			pais = (Pais) JOptionPane.showInputDialog(null, mensagem, "País",
					JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					favorito);
			Estado estados[] = estadoRN.itens(pais);
			if (estados.length == 0) {
				resultado = false;
				JOptionPane
						.showMessageDialog(null,
								"É preciso cadastrar algum estado para o "
										+ pais.getNome(), "",
								JOptionPane.ERROR_MESSAGE);
			} else {
				estado = estados[0];
			}

		}

		return resultado;

	}
}
