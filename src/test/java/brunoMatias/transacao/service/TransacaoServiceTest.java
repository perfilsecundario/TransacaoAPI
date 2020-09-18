package brunoMatias.transacao.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class TransacaoServiceTest {

	@Autowired
	private TransacaoService transacaoService;

	@Test
	@DisplayName("Nao deve retornar nulo ao acessar TransacaoService")
	public void TransacaoServiceNotNull() {
		assertNotNull(transacaoService);
	}
}
