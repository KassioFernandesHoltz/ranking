package br.com.ranking.DAOVetor;

import br.com.ranking.DAO.EstadoDAO;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;

public class EstadoDAOVetor implements EstadoDAO {

	private static int autoIncremento;
	private static int quantidade;
	private static Estado estados[] = new Estado[100];

	public EstadoDAOVetor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void incluir(Estado estado) {
		// TODO Auto-generated method stub
		autoIncremento++;
		estado.setCodigo(autoIncremento);
		estados[quantidade] = estado;
		quantidade++;
	}

	@Override
	public void atualizar(Estado estado) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (estados[i].getCodigo() == estado.getCodigo()) {
				estados[i] = estado;
				break;
			}
		}
	}

	@Override
	public Estado carregar(int codigo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (estados[i].getCodigo() == codigo) {
				return estados[i];
			}
		}
		return null;
	}

	@Override
	public void excluir(Estado estado) {
		// TODO Auto-generated method stub
		int pos = 0;
		boolean achou = false;
		for (int i = 0; i < quantidade; i++) {
			if (estados[i].getCodigo() == estado.getCodigo()) {
				pos = i;
				achou = true;
				break;
			}
		}

		if (achou) {
			for (int i = pos; i < quantidade; i++) {
				estados[i] = estados[i + 1];
			}
			quantidade--;
		}

	}

	@Override
	public Estado[] itens(Pais pais) {
		// TODO Auto-generated method stub
		int qtdEstado = 0;
		Estado aux[] = new Estado[quantidade];
		for (int i = 0; i < quantidade; i++) {
			if (estados[i].getPais().getCodigo() == pais.getCodigo()) {
				aux[qtdEstado] = estados[i];
				qtdEstado++;
			}
		}

		Estado auxiliar[] = new Estado[qtdEstado];
		for (int i = 0; i < qtdEstado; i++) {
			auxiliar[i] = aux[i];
		}

		return auxiliar;

	}

	@Override
	public Estado primeiro(Pais pais) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++){
			if(estados[i].getPais().getCodigo() == pais.getCodigo()){
				return estados[i];
			}
		}
		return null;
	}
	
	

}
