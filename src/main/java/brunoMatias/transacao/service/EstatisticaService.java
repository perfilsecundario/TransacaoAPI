package brunoMatias.transacao.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import brunoMatias.transacao.dataprovider.TransacaoDAO;
import brunoMatias.transacao.entities.Transacao;

//Esta classe contém toda a lógica relativa à lista de transações

@Service
public class EstatisticaService {

	private TransacaoDAO dao = new TransacaoDAO();

	public EstatisticaService(TransacaoDAO dao) {
		this.dao = dao;
	}
	
	
	
	public DoubleSummaryStatistics apresentaStats(DoubleSummaryStatistics stats) {

		if (dao.getTransacoes() != null) {
			
			List<Transacao> devolveTransacoesComMaisDeUmMinuto 
				= devolveTransacoesComMenosDeUmMinuto();
			stats = devolveTransacoesComMaisDeUmMinuto.stream()
				.collect(Collectors.summarizingDouble(Transacao::getValor));
			return stats;
			
		}
		return stats;
	}

	
	
	
	private List<Transacao> devolveTransacoesComMenosDeUmMinuto() {

		LocalDateTime date = LocalDateTime.now().minusMinutes(1);
		List<Transacao> transacoes = new ArrayList();
		
		for (int i = 0; i < dao.getTransacoes().size(); i++) {

			if (dao.getTransacoes().get(i).getDate().isAfter(date)) { 
				
				transacoes.add(dao.getTransacoes().get(i));
				
			}
		}
		return transacoes;
	}
}