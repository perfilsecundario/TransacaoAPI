package brunoMatias.transacao.exception;

import java.util.Date;

public class DetalheDoErro {

    private final Date timestamp;
    private final String mensagem;
    private final String detalheDoErro;


    public DetalheDoErro(Date timestamp, String mensagem,
    String detalheDoErro) {
    	
        super();
        this.timestamp = timestamp;
        this.mensagem = mensagem;
        this.detalheDoErro = detalheDoErro;
    }

    
    public Date getTimestamp() {
        return timestamp;
    }

       
    public String getMensagem() {
		return mensagem;
	}


	public String getDetalheDoErro() {
		return detalheDoErro;
	}

}


