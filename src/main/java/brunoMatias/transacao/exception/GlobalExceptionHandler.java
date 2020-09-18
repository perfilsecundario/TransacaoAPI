package brunoMatias.transacao.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    		MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        DetalheDoErro detalheDoErro = new DetalheDoErro(new Date(),
                "A transação informada possuí um ou mais parâmetros inválidos,"
                + " verifique em detalheDoErro.",
                ex.getMessage());

        return new ResponseEntity<>(detalheDoErro
        		, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
