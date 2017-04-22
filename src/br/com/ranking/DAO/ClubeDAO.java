package br.com.ranking.DAO;

import br.com.ranking.entidades.Clube;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;

public interface ClubeDAO {
	
	public void incluir(Clube clube);
	
	public void atualizar(Clube clube);
	
	public Clube carregar(int codigo);
	
	public void excluir(Clube clube);
	
	public Clube[] itens(Pais pais);
	
	public Clube[] itens(Estado estado);
	
	public Clube[] itens();
	
}
