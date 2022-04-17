package com.backend.exeption.handler;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler({
		Exception.class
	})
	@Nullable
	public  ResponseEntity<Object> handleException2(Exception ex, WebRequest request) throws Exception {
		return handleExceptionInternal(ex,null,null,HttpStatus.INTERNAL_SERVER_ERROR,request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String defaultMsg="";
		AppException c_ex=null;
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}
		
		if(ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException ex1=(MethodArgumentNotValidException)ex;
			Optional<ObjectError> objerror=ex1.getBindingResult().getAllErrors()
					.stream().filter(S->S.getDefaultMessage()!=null).findFirst();
			if(objerror.isPresent()) {
				defaultMsg=objerror.get().getDefaultMessage();
			}
			c_ex=new AppException(ex.getMessage(),new Date(),defaultMsg);
		}else if(ex instanceof TransactionSystemException) {
			TransactionSystemException ex1=(TransactionSystemException)ex;
			System.out.println(ex1.getRootCause().toString());
			c_ex=new AppException(ex.getMessage(),new Date(),ex1.getRootCause().toString());
		}
		
		
		new AppException(ex.getMessage(),new Date(),defaultMsg);
		
		
		
		return new ResponseEntity<>(c_ex, headers, status);
	}
	
}