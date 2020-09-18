package brunoMatias.transacao.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.DoubleSummaryStatistics;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import brunoMatias.transacao.service.EstatisticaService;


@WebMvcTest(value = EstatisticaController.class)
@RunWith(SpringRunner.class)
public class TransacaoControllerTest {

	private static final String request_estatistica = "/estatisticas";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EstatisticaService service;

	@Test
	@DisplayName("Retorna status 200 quando as estatisticas forem apresentadas")
	public void getTransactionStatistics() throws Exception {

		DoubleSummaryStatistics dss = new DoubleSummaryStatistics();

		when(service.apresentaStats(any(DoubleSummaryStatistics.class)))
			.thenReturn(dss);

		mvc.perform(get(request_estatistica)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is(200));
	}
}