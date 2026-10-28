package com.arti.SpringCRUD.Exception;


import com.arti.SpringCRUD.DTOs.ExceptionResponseDto;
import com.arti.SpringCRUD.DTOs.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> HandleDuplicateResourceException(DuplicateResourceException ex, HttpServletRequest req){
        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
                );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponseDto);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> HandleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest req){
        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponseDto);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> HandleRuntimeException(RuntimeException ex, HttpServletRequest req){
        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> HandleGenericException(Exception ex, HttpServletRequest req){
        ExceptionResponseDto exceptionResponseDto=new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto> HandleGenericException(MethodArgumentNotValidException ex, HttpServletRequest req){
        Map<String,String> fieldErros=new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> fieldErros.put(error.getField(),error.getDefaultMessage()));


        ValidationExceptionResponseDto validationExceptionResponseDto=new ValidationExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                req.getRequestURI(),
                fieldErros
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationExceptionResponseDto);
    }

}
