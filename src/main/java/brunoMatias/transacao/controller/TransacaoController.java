package brunoMatias.transacao.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import brunoMatias.transacao.entities.Transacao;
import brunoMatias.transacao.service.TransacaoService;

//Esta classe controla os endpoints de transações (SOLID:SRP)

@RestController
public class TransacaoController {

	@Autowired
	private TransacaoService service;

	
	
	@PostMapping(value = "/transacao", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> adicionarTransacao
	(@Valid @RequestBody Transacao transacao) {
		
		LocalDateTime date = LocalDateTime.now();

		if (transacao.getDate().isAfter(date))
			return new ResponseEntity<>("Transação não pode estar no futuro."
					, HttpStatus.UNPROCESSABLE_ENTITY);

		Transacao transacao1 = service.salvarTransacao(transacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(transacao1);
	}

	
	
	@DeleteMapping(value = "/transacao")
	public ResponseEntity<Transacao> deleteTodas(Transacao transacao) {
		service.DeletarTodas();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
