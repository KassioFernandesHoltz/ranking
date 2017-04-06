package br.com.ranking.DAOVetor;

import br.com.ranking.DAO.PaisDAO;
import br.com.ranking.entidades.Pais;

public class PaisDAOVetor implements PaisDAO {

	private static int autoIncremento;
	private static int quantidade;
	private static Pais paises[] = new Pais[100];
	private static Pais favorito;

	public PaisDAOVetor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pais getFavorito() {
		return favorito;
	}

	@Override
	public void setFavorito(Pais favorito) {
		PaisDAOVetor.favorito = favorito;
	}

	@Override
	public void incluir(Pais pais) {
		// TODO Auto-generated method stub
		autoIncremento++;
		pais.setCodigo(autoIncremento);
		paises[quantidade] = pais;

		quantidade++;

	}

	@Override
	public void atualizar(Pais pais) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (paises[i].getCodigo() == pais.getCodigo()) {
				paises[i] = pais;
				break;
			}
		}
	}

	@Override
	public Pais carregar(int codigo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (paises[i].getCodigo() == codigo) {
				return paises[i];
			}
		}
		return null;
	}

	@Override
	public void excluir(Pais pais) {
		// TODO Auto-generated method stub
		int pos = 0;
		boolean achou = false;
		for (int i = 0; i < quantidade; i++) {
			if (paises[i].getCodigo() == pais.getCodigo()) {
				pos = i;
				achou = true;
				break;
			}
		}

		if (achou) {
			for (int i = pos; i < quantidade; i++) {
				paises[i] = paises[i + 1];
			}
			quantidade--;
		}

	}

	@Override
	public Pais[] itens() {
		// TODO Auto-generated method stub
		Pais aux[] = new Pais[quantidade];
		for (int i = 0; i < quantidade; i++) {
			aux[i] = paises[i];
		}

		return aux;
	}

}
