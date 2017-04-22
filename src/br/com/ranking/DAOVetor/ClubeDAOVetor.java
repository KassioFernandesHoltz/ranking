package br.com.ranking.DAOVetor;

import br.com.ranking.DAO.ClubeDAO;
import br.com.ranking.entidades.Clube;
import br.com.ranking.entidades.Estado;
import br.com.ranking.entidades.Pais;

public class ClubeDAOVetor implements ClubeDAO {

	private static int autoIncremento;
	private static int quantidade;
	private static Clube clubes[] = new Clube[100];

	@Override
	public void incluir(Clube clube) {
		// TODO Auto-generated method stub
		autoIncremento++;
		clube.setCodigo(autoIncremento);
		clubes[quantidade] = clube;
		quantidade++;
	}

	@Override
	public void atualizar(Clube clube) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (clubes[i].getCodigo() == clube.getCodigo()) {
				clubes[i] = clube;
				break;
			}
		}
	}

	@Override
	public Clube carregar(int codigo) {
		// TODO Auto-generated method stub
		for (int i = 0; i < quantidade; i++) {
			if (clubes[i].getCodigo() == codigo) {
				return clubes[i];
			}
		}
		return null;
	}

	@Override
	public void excluir(Clube clube) {
		// TODO Auto-generated method stub
		int pos = 0;
		boolean achou = false;
		for (int i = 0; i < quantidade; i++) {
			if (clubes[i].getCodigo() == clube.getCodigo()) {
				pos = i;
				achou = true;
				break;
			}
		}

		if (achou) {
			for (int i = pos; i < quantidade; i++) {
				clubes[i] = clubes[i + 1];
			}
			quantidade--;
		}
	}

	@Override
	public Clube[] itens(Pais pais) {
		// TODO Auto-generated method stub
		int qtdClube = 0;
		Clube aux[] = new Clube[quantidade];
		for (int i = 0; i < quantidade; i++) {
			if (clubes[i].getCidade().getEstado().getPais().getCodigo() == pais
					.getCodigo()) {
				aux[qtdClube] = clubes[i];
				qtdClube++;
			}
		}
		Clube auxiliar[] = new Clube[qtdClube];
		for (int i = 0; i < qtdClube; i++) {
			auxiliar[i] = aux[i];
		}
		return auxiliar;
	}

	@Override
	public Clube[] itens(Estado estado) {
		// TODO Auto-generated method stub
		int qtdClube = 0;
		Clube aux[] = new Clube[quantidade];
		for (int i = 0; i < quantidade; i++) {
			if (clubes[i].getCidade().getEstado().getCodigo() == estado
					.getCodigo()) {
				aux[qtdClube] = clubes[i];
				qtdClube++;
			}
		}
		Clube auxiliar[] = new Clube[qtdClube];
		for (int i = 0; i < qtdClube; i++) {
			auxiliar[i] = aux[i];
		}
		return auxiliar;
	}

	@Override
	public Clube[] itens() {
		// TODO Auto-generated method stub
		Clube auxiliar[] = new Clube[quantidade];
		for (int i = 0; i < quantidade; i++) {
			auxiliar[i] = clubes[i];
		}
		return auxiliar;
	}

}
