package brunoMatias.transacao.service;

import org.springframework.stereotype.Service;

import brunoMatias.transacao.dataprovider.TransacaoDAO;
import brunoMatias.transacao.entities.Transacao;

@Service
public class TransacaoService {

	private TransacaoDAO dao = new TransacaoDAO();

	
	public TransacaoService(TransacaoDAO dao) {
		this.dao = dao;
	}


	
	public Transacao salvarTransacao(Transacao transacao) {		
		dao.adiciona(transacao);
		return transacao;
	}


	
	public void DeletarTodas() {
		dao.deleteTransacoes();
	}

}
