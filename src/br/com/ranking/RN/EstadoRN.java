package br.com.ranking.RN;

import br.com.ranking.DAO.EstadoDAO;
import br.com.ranking.entidades.Estado;
import br.com.ranking.util.DAOFactory;

public class EstadoRN {
	private EstadoDAO estadoDAO;
	
	public EstadoRN(){
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}
	
	public void incluir(Estado estado){
		this.estadoDAO.incluir(estado);
	}
	
	public Estado carregar(int codigo){
		return this.estadoDAO.carregar(codigo);
	}
	
	public void atualizar(Estado estado){
		this.estadoDAO.atualizar(estado);
	}
	
	public void excluir(int codigo){
		this.estadoDAO.excluir(codigo);
	}
	
	public String listar(){
		return this.estadoDAO.listar();
	}
	
	public Estado[] itens(int codPais){
		return this.estadoDAO.itens(codPais);
	}
	
}
