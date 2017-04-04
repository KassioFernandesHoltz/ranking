package br.com.ranking.RN;

import br.com.ranking.DAO.PaisDAO;
import br.com.ranking.entidades.Pais;
import br.com.ranking.util.DAOFactory;

public class PaisRN {

	private PaisDAO paisDAO;

	public PaisRN() {
		this.paisDAO = DAOFactory.criarPaisDAO();
	}

	public void incluir(Pais pais) {
		this.paisDAO.incluir(pais);
	}

	public Pais carregar(int codigo) {
		return this.paisDAO.carregar(codigo);
	}

	public void atualizar(Pais pais) {
		this.paisDAO.atualizar(pais);
	}

	public void excluir(int codigo) {
		this.paisDAO.excluir(codigo);
	}

	public String listar() {
		return this.paisDAO.listar();
	}

	public Pais[] itens() {
		return this.paisDAO.itens();
	}

}
