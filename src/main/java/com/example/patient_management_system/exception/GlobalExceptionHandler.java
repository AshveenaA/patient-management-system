package com.example.patient_management_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> exceptionHandler(MethodArgumentNotValidException ex){

        Map<String,String> errors= new HashMap<>();

        ex.getBindingResult().getFieldErrors().
                forEach(error ->errors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String,String>> emailalreadyesistexceptionHandler(EmailAlreadyExistException ex){
        Map<String,String> errors= new HashMap<>();
                errors.put("message","Email already exist");

        return ResponseEntity.badRequest().body(errors);
    }
}
