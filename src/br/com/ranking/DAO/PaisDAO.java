package br.com.ranking.DAO;

import br.com.ranking.entidades.Pais;

public interface PaisDAO {

	public void incluir(Pais pais);

	public void atualizar(Pais pais);

	public Pais carregar(int codigo);

	public String listar();

	public void excluir(int codigo);

	public Pais[] itens();
	
	public Pais favorito();

}
