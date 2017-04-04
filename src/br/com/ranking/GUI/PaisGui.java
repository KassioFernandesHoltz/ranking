package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Pais;
import br.com.ranking.enumeracoes.Confederacao;
import br.com.ranking.enumeracoes.SimNao;

public class PaisGui extends CrudGuiImpl {

	public void incluir() {

		Pais paisAux = new Pais();
		PaisRN paisRN = new PaisRN();
		Pais favorito = paisRN.favorito();
		String nome;
		String sigla;
		Confederacao confederacao;
		SimNao apurarRanking;

		if (favorito == null) {
			confederacao = Confederacao.AFC;
		} else {
			confederacao = favorito.getConfederacao();
		}

		nome = JOptionPane.showInputDialog(null, "Informe o Nome", "Pais",
				JOptionPane.QUESTION_MESSAGE);

		sigla = JOptionPane.showInputDialog(null, "Informe a Sigla", "Sigla",
				JOptionPane.QUESTION_MESSAGE);

		confederacao = (Confederacao) (JOptionPane.showInputDialog(null,
				"Escolha a Federação", "Federação",
				JOptionPane.QUESTION_MESSAGE, null, Confederacao.values(),
				confederacao));

		apurarRanking = (SimNao) (JOptionPane.showInputDialog(null,
				"Apurar Ranking?", "Ranking", JOptionPane.QUESTION_MESSAGE,
				null, SimNao.values(), SimNao.Nao));

		paisAux.setNome(nome);
		paisAux.setSigla(sigla.toUpperCase());
		paisAux.setConfederacao(confederacao);
		paisAux.setApurarRanking(apurarRanking);

		paisRN.incluir(paisAux);

	}

	public void alterar() {

		Pais paisAux = new Pais();
		PaisRN paisRN = new PaisRN();

		Pais paises[] = paisRN.itens();

		paisAux = (Pais) JOptionPane.showInputDialog(null, "Escolha o País",
				"Alterar", JOptionPane.DEFAULT_OPTION, null, paises, paises[0]);

		paisAux.setNome(JOptionPane.showInputDialog("Altere o nome",
				paisAux.getNome()));

		paisAux.setSigla(JOptionPane.showInputDialog("Altere a sigla",
				paisAux.getSigla()).toUpperCase());

		paisAux.setConfederacao((Confederacao) JOptionPane.showInputDialog(
				null, "Altere a Confederação", "Confederação",
				JOptionPane.DEFAULT_OPTION, null, Confederacao.values(),
				paisAux.getConfederacao()));

		paisAux.setApurarRanking((SimNao) JOptionPane.showInputDialog(null,
				"Apurar Ranking?", "Ranking", JOptionPane.DEFAULT_OPTION, null,
				SimNao.values(), paisAux.getApurarRanking()));

		paisRN.atualizar(paisAux);

	}

	public void listar() {
		PaisRN paisRN = new PaisRN();
		JOptionPane.showMessageDialog(null, paisRN.listar());
	}

	public void excluir() {

		Pais paisAux = new Pais();
		PaisRN paisRN = new PaisRN();

		Pais paises[] = paisRN.itens();

		paisAux = (Pais) JOptionPane.showInputDialog(null, "Escolha o País",
				"Excluir", JOptionPane.DEFAULT_OPTION, null, paises, paises[0]);

		paisRN.excluir(paisAux.getCodigo());

	}

}
