package brunoMatias.transacao.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brunoMatias.transacao.service.EstatisticaService;

//Esta classe controla a inserção de dados no sistema (SOLID:SRP)

@RestController
public class EstatisticaController {

	@Autowired
	private EstatisticaService service;

	@GetMapping(value = "/estatisticas", produces = MediaType
			.APPLICATION_JSON_VALUE)
	public ResponseEntity<DoubleSummaryStatistics> retornarTodas() {
		DoubleSummaryStatistics dss = new DoubleSummaryStatistics();
		return ResponseEntity.ok(service.apresentaStats(dss));
	}

}
