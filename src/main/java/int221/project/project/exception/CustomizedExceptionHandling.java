package int221.project.project.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ExceptionResponse> handleExceptions(ProductException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse(exception.getErrorCode(), exception.getMessage(),
                LocalDateTime.now());
        ResponseEntity<ExceptionResponse> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}