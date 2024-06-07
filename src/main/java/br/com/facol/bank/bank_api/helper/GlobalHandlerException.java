package br.com.facol.bank.bank_api.helper;

import br.com.facol.bank.bank_api.exception.ExceptionDetails;
import br.com.facol.bank.bank_api.exception.ValidationExceptionDetails;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ConstraintViolation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalTime.now;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {


    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionDetails handleConstraintViolation(ConstraintViolationException ex) {
        return ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(UNPROCESSABLE_ENTITY.value())
                .title(UNPROCESSABLE_ENTITY.name())
                .details(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")))
                .developerMessage(ex.getClass().getName())
                .build();
    }

}
