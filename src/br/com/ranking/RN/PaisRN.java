package br.com.ranking.RN;

import br.com.ranking.DAO.PaisDAO;
import br.com.ranking.entidades.Pais;
import br.com.ranking.enumeracoes.SimNao;
import br.com.ranking.util.DAOFactory;

public class PaisRN {

	private PaisDAO paisDAO;

	public PaisRN() {
		this.paisDAO = DAOFactory.criarPaisDAO();
	}

	public void incluir(Pais pais) {
		this.paisDAO.incluir(pais);

		// configurar o favorito
		if (pais.getApurarRanking() == SimNao.Sim) {

			// verifica se o antigo favorito é diferente de vazio e o coloca
			// como não favorito
			if (this.paisDAO.getFavorito() != null) {
				Pais antigoFavorito = this.paisDAO.getFavorito();
				antigoFavorito.setApurarRanking(SimNao.Nao);
				this.paisDAO.atualizar(antigoFavorito);
			}

			this.paisDAO.setFavorito(pais);
		}
	}

	public Pais carregar(int codigo) {
		return this.paisDAO.carregar(codigo);
	}

	public void atualizar(Pais pais) {
		this.paisDAO.atualizar(pais);

		// configurar o favorito
		if (pais.getApurarRanking() == SimNao.Sim) {

			// verifica se o antigo favorito é diferente de vazio e o coloca
			// como não favorito
			if (this.paisDAO.getFavorito() != null) {
				Pais antigoFavorito = this.paisDAO.getFavorito();
				antigoFavorito.setApurarRanking(SimNao.Nao);
				this.paisDAO.atualizar(antigoFavorito);
			}

			this.paisDAO.setFavorito(pais);
		}

	}

	public void excluir(Pais pais) {
		this.paisDAO.excluir(pais);

		// configurar o favorito
		if (pais.getApurarRanking() == SimNao.Sim) {
			this.paisDAO.setFavorito(null);
		}
	}

	public String listar() {
		return this.paisDAO.listar();
	}

	public Pais[] itens() {
		return this.paisDAO.itens();
	}

	public Pais getFavorito() {
		return this.paisDAO.getFavorito();
	}

	public void setFavorito(Pais pais) {
		this.paisDAO.setFavorito(pais);
	}

}
