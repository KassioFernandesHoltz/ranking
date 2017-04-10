package br.com.ranking.DAOVetor;

import br.com.ranking.DAO.CidadeDAO;
import br.com.ranking.entidades.Cidade;
import br.com.ranking.entidades.Estado;

public class CidadeDAOVetor implements CidadeDAO {
	
	private static int autoIncremento;
	private static int quantidade;
	private static Cidade cidades[] = new Cidade[100];
	
	@Override
	public void incluir(Cidade cidade) {
		// TODO Auto-generated method stub
		autoIncremento++;
		cidade.setCodigo(autoIncremento);
		cidades[quantidade] = cidade;
		quantidade++;
	}

	@Override
	public void atualizar(Cidade cidade) {
		// TODO Auto-generated method stub
		for(int i = 0; i < quantidade ; i++){
			if(cidades[i].getCodigo() == cidade.getCodigo()){
				cidades[i] = cidade;
				break;
			}
		}
	}

	@Override
	public Cidade carregar(int codigo) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < quantidade; i++){
			if (cidades[i].getCodigo() == codigo) {
				return cidades[i];
			}
		}
		
		return null;
	}

	@Override
	public void excluir(Cidade cidade) {
		// TODO Auto-generated method stub
		int pos = 0;
		boolean achou = false;
		for (int i = 0; i < quantidade; i++) {
			if (cidades[i].getCodigo() == cidade.getCodigo()) {
				pos = i;
				achou = true;
				break;
			}
		}
		
		if (achou) {
			for (int i = pos; i < quantidade; i++) {
				cidades[i] = cidades[i + 1];
			}
			quantidade--;
		}

	}

	@Override
	public Cidade[] itens(Estado estado) {
		// TODO Auto-generated method stub
		int qtdEstado = 0;
		Cidade aux[] = new Cidade[quantidade];
		for (int i = 0; i < quantidade; i++) {
			if (cidades[i].getEstado().getCodigo() == estado.getCodigo()) {
				aux[qtdEstado] = cidades[i];
				qtdEstado++;
			}
		}
		Cidade auxiliar[] = new Cidade[qtdEstado];
		for (int i = 0; i < qtdEstado; i++) {
			auxiliar[i] = aux[i];
		}
		return auxiliar;
	}

}
