package com.error;


import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * App exception handler
 * @author Gabriel
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    private Logger log = Logger.getLogger(this.getClass());

    /**
     * Handle server errors and response with json
     * @param exception thrown exception object
     * @param request web request object
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleInvalidRequest(Exception exception, WebRequest request){
        ErrorResponse error = new ErrorResponse("Internal server exception", exception.getMessage());
        log.error("Internal Server error:  " + request.getDescription(false));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(exception, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);

    }
}