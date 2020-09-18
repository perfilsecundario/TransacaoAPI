package brunoMatias.transacao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

	@Positive
	@NotNull
	private BigDecimal valor;

	@NotNull
	private LocalDateTime date;

	
	
	public double getValor() {
		return valor.doubleValue();
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}