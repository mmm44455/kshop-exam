package com.vti.kshop_exam.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ErrorREpon {
    private String timestamp;
    private String message;
    private Map<String,String> errors;

    public ErrorREpon(String message) {
        this.timestamp= LocalDateTime.now().toString();
        this.message = message;
    }

    public ErrorREpon(String message, Map<String, String> errors) {
     this(message);
        this.errors = errors;
    }
}
