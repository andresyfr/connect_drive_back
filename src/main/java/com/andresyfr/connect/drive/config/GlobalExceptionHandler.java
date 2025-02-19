package com.andresyfr.connect.drive.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.andresyfr.connect.drive.dtos.ErrorResponse;
import com.andresyfr.connect.drive.services.exceptions.AccessDeniedException;
import com.andresyfr.connect.drive.services.exceptions.AccessDeniedExceptionView;
import com.andresyfr.connect.drive.services.exceptions.ResourceNotFoundException;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedExceptionView.class)
    public RedirectView notFoundException(final AccessDeniedExceptionView e, RedirectAttributes attributes) throws IOException {
        e.getMessage();
        RedirectView redirectView = new RedirectView("/unauthorized",true);
        redirectView.addStaticAttribute("message",e.getMessage());
        attributes.addFlashAttribute("message", e.getMessage());
        return redirectView;
    }

    // Manejo de AccessDeniedException (cuando el acceso es denegado)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Acceso denegado: " + ex.getMessage());
        errorResponse.setStatusCode(403); // Forbidden
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
    
    // Si no es un error relacionado con recursos estáticos, delegar el manejo
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoStaticResource(NoHandlerFoundException ex) {
        if (ex.getMessage().contains("No static resource")) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Recurso estático no encontrado: " + ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }  
        
    // Manejo de 404 Not Found, otra forma de hacerlo
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Recurso no encontrado: " + ex.getMessage());
        errorResponse.setStatusCode(404);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    // Maneja todos los errores del servidor de la aplicación
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllErrors(Exception ex, WebRequest request) {
    	if (ex.getMessage().contains("No static resource errors/unauthorized.")) {
            return handleAccessDenied(new AccessDeniedException(ex.getMessage(),ex.getCause()));
        }else
        	if (ex.getMessage().contains("No static resource")) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("Recurso estático no encontrado: " + ex.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }	
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Ocurrió un error inesperado: " + ex.getMessage());
        errorResponse.setStatusCode(500);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
