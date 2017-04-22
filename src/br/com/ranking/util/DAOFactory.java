package br.com.ranking.util;

import br.com.ranking.DAO.CidadeDAO;
import br.com.ranking.DAO.ClubeDAO;
import br.com.ranking.DAO.EstadoDAO;
import br.com.ranking.DAO.PaisDAO;
import br.com.ranking.DAOVetor.CidadeDAOVetor;
import br.com.ranking.DAOVetor.ClubeDAOVetor;
import br.com.ranking.DAOVetor.EstadoDAOVetor;
import br.com.ranking.DAOVetor.PaisDAOVetor;

public class DAOFactory {

	public static PaisDAO criarPaisDAO() {
		PaisDAOVetor paisDAO = new PaisDAOVetor();
		return paisDAO;
	}

	public static EstadoDAO criarEstadoDAO() {
		EstadoDAOVetor estadoDAO = new EstadoDAOVetor();
		return estadoDAO;
	}

	public static CidadeDAO criarCidadeDAO() {
		CidadeDAOVetor cidadeDAO = new CidadeDAOVetor();
		return cidadeDAO;
	}

	public static ClubeDAO criarClubeDAO() {
		ClubeDAOVetor clubeDAO = new ClubeDAOVetor();
		return clubeDAO;
	}

}
