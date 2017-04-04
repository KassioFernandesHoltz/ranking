package br.com.ranking.DAO;

import br.com.ranking.entidades.Estado;

public interface EstadoDAO {

	public void incluir(Estado estado);

	public void atualizar(Estado estado);

	public Estado carregar(int codigo);

	public String listar();

	public void excluir(int codigo);

	public Estado[] itens(int codPais);

}
