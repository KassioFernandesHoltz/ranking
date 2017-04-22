package br.com.ranking.RN;

import br.com.ranking.DAO.EstadoDAO;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;
import br.com.ranking.util.DAOFactory;

public class EstadoRN {
	private EstadoDAO estadoDAO;

	public EstadoRN() {
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}

	public void incluir(Estado estado) {
		this.estadoDAO.incluir(estado);
	}

	public Estado carregar(int codigo) {
		return this.estadoDAO.carregar(codigo);
	}

	public void atualizar(Estado estado) {
		this.estadoDAO.atualizar(estado);
	}

	public void excluir(Estado estado) {
		this.estadoDAO.excluir(estado);
	}

	public Estado[] itens(Pais pais) {
		return this.estadoDAO.itens(pais);
	}
	
	public Estado primeiro(Pais pais){
		return this.estadoDAO.primeiro(pais);
	}

}
