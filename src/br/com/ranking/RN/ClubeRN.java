package br.com.ranking.RN;

import br.com.ranking.DAO.ClubeDAO;
import br.com.ranking.entidades.Clube;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;
import br.com.ranking.util.DAOFactory;

public class ClubeRN {
	private ClubeDAO clubeDAO;
	
	public ClubeRN(){
		this.clubeDAO = DAOFactory.criarClubeDAO();
	}
	
	public void incluir(Clube clube){
		this.clubeDAO.incluir(clube);
	}
	
	public Clube carregar(int codigo){
		return this.clubeDAO.carregar(codigo);
	}
	
	public void atualizar(Clube clube){
		this.clubeDAO.atualizar(clube);
	}
	
	public void excluir(Clube clube){
		this.clubeDAO.excluir(clube);
	}
	
	public Clube[] itens(Pais pais){
		return this.clubeDAO.itens(pais);
	}
	
	public Clube[] itens(Estado estado){
		return this.clubeDAO.itens(estado);
	}
	
	public Clube[] itens(){
		return this.clubeDAO.itens();
	}
	
}
