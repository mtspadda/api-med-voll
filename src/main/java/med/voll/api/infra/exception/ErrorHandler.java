package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorHandler404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity errorHandler400(MethodArgumentNotValidException exception){
        var erro = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(ErroValidationHandlerDTO::new).toList());
    }

    private record ErroValidationHandlerDTO(String field, String message){

        public ErroValidationHandlerDTO(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
