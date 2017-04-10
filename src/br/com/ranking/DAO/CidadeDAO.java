package br.com.ranking.DAO;

import br.com.ranking.entidades.Cidade;
import br.com.ranking.entidades.Estado;

public interface CidadeDAO {
	
	public void incluir(Cidade cidade);

	public void atualizar(Cidade cidade);

	public Cidade carregar(int codigo);

	public void excluir(Cidade cidade);

	public Cidade[] itens(Estado estado);
	
}
