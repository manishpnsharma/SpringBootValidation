package com.manishpnsharma.validation.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    /*@ExceptionHandler(EmptyInputFieldException.class)
    protected ResponseEntity<String> handleEmptyInput(EmptyInputFieldException emptyInputFieldException) {
        return new ResponseEntity<>("Field is empty ", HttpStatus.BAD_REQUEST);
    }*/
    @ExceptionHandler(NoSuchUserExistsException.class)
    protected ResponseEntity<String> handleNoSuchUserExistsException(NoSuchUserExistsException emptyInputFieldException) {
        return new ResponseEntity<>("NO USER PRESENT WITH ID", HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>("Change Http Method Or URL Or input Parameter", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("NO USER PRESENT WITH ID FOR DELETE", HttpStatus.NOT_FOUND);
    }
   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }*/
    //NoResourceFoundException
}