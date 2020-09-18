package brunoMatias.transacao.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import brunoMatias.transacao.entities.Transacao;



@Component
public class TransacaoDAO {

	private List<Transacao> transacoes = new ArrayList<>();

	
	public void adiciona(Transacao transacao) {

		transacoes.add(transacao);
	}

	
	
	public List<Transacao> getTransacoes() {
		return this.transacoes;
	}

	
	
	public void deleteTransacoes() {
		this.transacoes = new ArrayList<>();
	}
}
