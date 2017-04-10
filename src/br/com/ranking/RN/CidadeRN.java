package br.com.ranking.RN;

import br.com.ranking.DAO.CidadeDAO;
import br.com.ranking.entidades.Cidade;
import br.com.ranking.entidades.Estado;
import br.com.ranking.util.DAOFactory;

public class CidadeRN {
	
	private CidadeDAO cidadeDAO;
	
	public CidadeRN(){
		this.cidadeDAO = DAOFactory.criarCidadeDAO();
	}
	
	public void incluir(Cidade cidade) {
		this.cidadeDAO.incluir(cidade);
	}
	
	public Cidade carregar(int codigo) {
		return this.cidadeDAO.carregar(codigo);
	}
	
	public void atualizar(Cidade cidade) {
		this.cidadeDAO.atualizar(cidade);
	}
	
	public void excluir(Cidade cidade) {
		this.cidadeDAO.excluir(cidade);
	}
	
	public Cidade[] itens(Estado estado) {
		return this.cidadeDAO.itens(estado);
	}
	
}
