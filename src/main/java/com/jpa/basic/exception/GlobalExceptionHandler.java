package com.jpa.basic.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoProductException.class)
    protected RedirectView handleNoProductException(NoProductException noProductException){
        return new RedirectView("/error/500");
    }
}
