package br.com.ranking.util;

import br.com.ranking.DAO.EstadoDAO;
import br.com.ranking.DAO.PaisDAO;
import br.com.ranking.DAOVetor.EstadoDAOVetor;
import br.com.ranking.DAOVetor.PaisDAOVetor;

public class DAOFactory {

	public static PaisDAO criarPaisDAO() {
		PaisDAOVetor paisDAO = new PaisDAOVetor();
		return paisDAO;
	}
	
	public static EstadoDAO criarEstadoDAO(){
		EstadoDAOVetor estadoDAO = new EstadoDAOVetor();
		return estadoDAO;
	}

}
