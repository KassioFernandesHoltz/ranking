package br.com.ranking.GUI;

import javax.swing.JOptionPane;

import br.com.ranking.RN.CidadeRN;
import br.com.ranking.RN.ClubeRN;
import br.com.ranking.RN.EstadoRN;
import br.com.ranking.RN.PaisRN;
import br.com.ranking.entidades.Cidade;
import br.com.ranking.entidades.Clube;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;
import br.com.ranking.enumeracoes.Confederacao;
import br.com.ranking.enumeracoes.SimNao;
import br.com.ranking.util.RankingUtil;

public class ClubeGUI extends CrudGuiImpl {
	PaisRN paisRN = new PaisRN();
	EstadoRN estadoRN = new EstadoRN();
	CidadeRN cidadeRN = new CidadeRN();
	ClubeRN clubeRN = new ClubeRN();
	Pais favorito = paisRN.getFavorito();
	Pais pais = new Pais();
	Estado estado = new Estado();
	String nome;
	Cidade cidade = new Cidade();
	Clube clube = new Clube();
	
	
	static {
		Pais paisAux1 = new Pais();
		Pais paisAux2 = new Pais();
		Estado estadoAux1 = new Estado();
		Estado estadoAux2 = new Estado();
		Estado estadoAux3 = new Estado();
		Estado estadoAux4 = new Estado();
		Cidade cidade1 = new Cidade();
		Cidade cidade2 = new Cidade();
		Cidade cidade3 = new Cidade();
		Cidade cidade4 = new Cidade();
		Cidade cidade5 = new Cidade();
		PaisRN paisAuxRN = new PaisRN();
		EstadoRN estadoAuxRn = new EstadoRN();
		CidadeRN cidadeRN = new CidadeRN();
		

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
		
		cidade1.setNome("Rio de Janeiro");
		cidade1.setEstado(estadoAux2);
		cidadeRN.incluir(cidade1);
		
		cidade2.setNome("Campos");
		cidade2.setEstado(estadoAux2);
		cidadeRN.incluir(cidade2);
		
		cidade3.setNome("Cariacica");
		cidade3.setEstado(estadoAux1);
		cidadeRN.incluir(cidade3);
		
		cidade4.setNome("Córsega");
		cidade4.setEstado(estadoAux3);
		cidadeRN.incluir(cidade4);
		
		cidade5.setNome("Vitória");
		cidade5.setEstado(estadoAux1);
		cidadeRN.incluir(cidade5);
		
	}
	
	public void incluir() {

		Clube clubeAux = new Clube();

		if (verificaCidade()) {

			clubeAux.setNome(RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog(null, "Informe o nome do clube", "Clube",
							JOptionPane.QUESTION_MESSAGE)));
			clubeAux.setCidade((Cidade) JOptionPane.showInputDialog(null,
					"Escolha a cidade do clube", "Cidade",
					JOptionPane.QUESTION_MESSAGE, null, cidadeRN.itens(estado),
					cidade));

			clubeRN.incluir(clubeAux);

		}

	}

	public void alterar() {
		Clube clubeAux = new Clube();
		Pais paisAux = new Pais();
		Estado estadoAux = new Estado();
		Cidade cidadeAux = new Cidade();
		if (verificaClube()) {
			clubeAux = (Clube) JOptionPane.showInputDialog(null,
					"Escolha o Clube", "Clube", JOptionPane.QUESTION_MESSAGE,
					null, clubeRN.itens(estado), clube);
			favorito = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o novo País do clube", "Pais",
					JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					clubeAux.getCidade().getEstado().getPais());

			if (favorito.getCodigo() == clubeAux.getCidade().getEstado()
					.getPais().getCodigo()) {
				estadoAux = clubeAux.getCidade().getEstado();
			} else {
				estadoAux = estadoRN.primeiro(favorito);
			}

			estado = (Estado) JOptionPane.showInputDialog(null,
					"Escolha o novo estado do clube", "Estado",
					JOptionPane.QUESTION_MESSAGE, null,
					estadoRN.itens(favorito), estadoAux);

			if (estado.getCodigo() == clubeAux.getCidade().getEstado()
					.getCodigo()) {
				cidadeAux = clubeAux.getCidade();
			} else {
				cidadeAux = cidadeRN.primeiro(estado);
			}

			clubeAux.setCidade((Cidade) JOptionPane.showInputDialog(null,
					"Escolha a nova cidade do clube", "Estado",
					JOptionPane.QUESTION_MESSAGE, null, cidadeRN.itens(estado),
					cidadeAux));

			clubeAux.setNome(RankingUtil.PrimeiraLetraMaiuscula(JOptionPane
					.showInputDialog(null, "Informe o novo nome do clube",
							clubeAux.getNome())));
			clubeRN.atualizar(clubeAux);

		}
	}

	private boolean verificaCidade() {
		boolean resultado = true;

		favorito = paisRN.getFavorito();
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
			favorito = (Pais) JOptionPane.showInputDialog(null,
					"Escolha o País do clube", "País",
					JOptionPane.QUESTION_MESSAGE, null, paisRN.itens(),
					favorito);
			Estado estados[] = estadoRN.itens(favorito);
			if (estados.length == 0) {
				resultado = false;
				JOptionPane.showMessageDialog(
						null,
						"É preciso cadastrar algum estado para o "
								+ favorito.getNome(), "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				estado = estados[0];
				estado = (Estado) JOptionPane.showInputDialog(null,
						"Escolha o Estado do clube", "Estado",
						JOptionPane.QUESTION_MESSAGE, null,
						estadoRN.itens(favorito), estado);
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
		}

		return resultado;
	}

	private boolean verificaClube() {
		boolean resultado = true;

		if (verificaCidade()) {
			Clube clubes[] = clubeRN.itens(estado);
			if (clubes.length == 0) {
				resultado = false;
				JOptionPane.showMessageDialog(
						null,
						"É preciso cadastrar algum clube no estado "
								+ estado.getNome(), "",
						JOptionPane.ERROR_MESSAGE);
			} else {
				clube = clubes[0];
			}
		}

		return resultado;
	}

}
