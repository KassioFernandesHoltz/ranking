package br.com.ranking.DAO;

import br.com.ranking.entidades.Pais;

public interface PaisDAO {

	public void incluir(Pais pais);

	public void atualizar(Pais pais);

	public Pais carregar(int codigo);

	public void excluir(Pais pais);

	public Pais[] itens();

	public void setFavorito(Pais pais);

	public Pais getFavorito();

}
