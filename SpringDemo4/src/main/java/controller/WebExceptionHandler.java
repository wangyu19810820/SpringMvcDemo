package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by admin on 2017/5/23.
 */
@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(SpitteNotFoundException.class)
    public String spitterNotFoundExceptionHandler() {
        return "error/notfound2";
    }
}
