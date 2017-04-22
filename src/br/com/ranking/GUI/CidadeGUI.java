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

	PaisRN paisRN = new PaisRN();
	EstadoRN estadoRN = new EstadoRN();
	CidadeRN cidadeRN = new CidadeRN();
	Pais favorito = paisRN.getFavorito();
	Pais pais = new Pais();
	Estado estado = new Estado();
	String nome;
	Cidade cidade = new Cidade();
	
	/*
	static {
		Pais paisAux1 = new Pais();
		Pais paisAux2 = new Pais();
		Estado estadoAux1 = new Estado();
		Estado estadoAux2 = new Estado();
		Estado estadoAux3 = new Estado();
		Estado estadoAux4 = new Estado();
		PaisRN paisAuxRN = new PaisRN();
		EstadoRN estadoAuxRn = new EstadoRN();

		paisAux1.setNome("Brasil");
		paisAux1.setSigla("BRA");
		paisAux1.setConfederacao(Confederacao.CONMEBOL);
		paisAux1.setApurarRanking(SimNao.Sim);
		paisAuxRN.incluir(paisAux1);

		estadoAux1.setNome("Espirito Santo");
		estadoAux1.setSigla("ES");
		estadoAux1.setPais(paisAux1);
		estadoAuxRn.incluir(estadoAux1);

		estadoAux2.setNome("Rio de Janeiro");
		estadoAux2.setSigla("RJ");
		estadoAux2.setPais(paisAux1);
		estadoAuxRn.incluir(estadoAux2);

		paisAux2.setNome("Italia");
		paisAux2.setSigla("ITA");
		paisAux2.setConfederacao(Confederacao.UEFA);
		paisAux2.setApurarRanking(SimNao.Nao);
		paisAuxRN.incluir(paisAux2);

		estadoAux3.setNome("Milão");
		estadoAux3.setSigla("MI");
		estadoAux3.setPais(paisAux2);
		estadoAuxRn.incluir(estadoAux3);

		estadoAux4.setNome("Napoli");
		estadoAux4.setSigla("NP");
		estadoAux4.setPais(paisAux2);
		estadoAuxRn.incluir(estadoAux4);

	} */

	public void incluir() {

		Cidade cidadeAux = new Cidade();

		if (verificaEstado("Selecione o País")) {

			cidadeAux.setNome(RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog(null, "Informe o nome da cidade",
							"Cidade", JOptionPane.QUESTION_MESSAGE)));

			cidadeAux.setEstado((Estado) JOptionPane.showInputDialog(null,
					"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
					null, estadoRN.itens(pais), estado));

			cidadeRN.incluir(cidadeAux);

		}

	}

	public void alterar() {

		Cidade cidadeAux = new Cidade();
		Estado estadoAux = new Estado();

		if (verificaCidade("Informe o Estado do cidade")) {

			cidadeAux = (Cidade) JOptionPane.showInputDialog(null,
					"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
					null, cidadeRN.itens(estado), cidade);

			cidadeAux.setNome(RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog("Altere o nome", cidadeAux.getNome())));

			favorito = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o País da cidade", "País",
					JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					cidadeAux.getEstado().getPais());

			if (favorito.getCodigo() == cidadeAux.getEstado().getPais()
					.getCodigo()) {
				estadoAux = cidadeAux.getEstado();
			} else {
				estadoAux = estado;
			}

			cidadeAux.setEstado((Estado) JOptionPane.showInputDialog(null,
					"Escolha o Estado", "Estado", JOptionPane.QUESTION_MESSAGE,
					null, estadoRN.itens(favorito), estadoAux));

			cidadeRN.atualizar(cidadeAux);

		}

	}

	public void listar() {

		String aux = "";
		if (verificaCidade("Informe o Estado para listar as cidades")) {

			for (Cidade cidade : cidadeRN.itens(estado)) {
				aux += "Código: " + cidade.getCodigo() + " Nome: "
						+ cidade.getNome() + "\n";
			}

			JOptionPane.showMessageDialog(null, aux);
		}

	}

	public void excluir() {

		Cidade cidadeAux = new Cidade();

		if (verificaCidade("Informe o Estado da cidade que deseja Excluir")) {

			cidadeAux = (Cidade) JOptionPane.showInputDialog(null,
					"Escolha a Cidade", "Cidade", JOptionPane.QUESTION_MESSAGE,
					null, cidadeRN.itens(estado), cidade);
			cidadeRN.excluir(cidadeAux);

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

	public boolean verificaCidade(String mensagem) {

		boolean resultado = true;

		if (!verificaEstado("Selecione o Estado")) {
			return false;
		} else {
			estado = (Estado) JOptionPane.showInputDialog(null, mensagem,
					"Estado", JOptionPane.QUESTION_MESSAGE, null,
					estadoRN.itens(pais), estado);
			Cidade cidades[] = cidadeRN.itens(estado);

			if (cidades.length == 0) {
				resultado = false;
				JOptionPane.showMessageDialog(
						null,
						"É preciso cadastrar alguma cidade para  "
								+ estado.getNome(), "",
						JOptionPane.ERROR_MESSAGE);

			} else {
				cidade = cidades[0];
			}

		}

		return resultado;

	}

}
