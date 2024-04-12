package com.devcarlos.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devcarlos.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // isso daqui vaai interceptar para mim as excecoes que aconteceraem para que esse objeto possa executar um ppossivel tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) // com esta anotacao estou a dizer para o meu metodo de que qualquer excecao deste tipo"ResourceNotFoundException" que foi lançada e vai fazer tratamento que estiver aqui dentro
	public ResponseEntity<StandardError> ressourceNotfound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error =" Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
    
	
}
