package br.com.ranking.DAO;

import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;

public interface EstadoDAO {

	public void incluir(Estado estado);

	public void atualizar(Estado estado);

	public Estado carregar(int codigo);

	public void excluir(Estado estado);

	public Estado[] itens(Pais pais);

}
