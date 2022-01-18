package study.spring.AroundHubSpringBoot.common.exception;

import org.springframework.http.HttpStatus;
import study.spring.AroundHubSpringBoot.common.Constants;

public class AroundException extends Exception {
	
	private static final long serialVersionUID = 4663380430591151694L;
	// 직렬화(serialization)를 위해 생성
	
	private Constants.ExceptionClass exceptionClass;
	private HttpStatus httpStatus;
	
	public AroundException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
		super(exceptionClass.toString() + message);
		this.exceptionClass = exceptionClass;
		this.httpStatus = httpStatus;
	}
	
	public Constants.ExceptionClass getExceptionClass() {
		return exceptionClass;
	}
	
	public int getHttpStatusCode() {
		return httpStatus.value();
	}
	
	public String getHttpStatusType() {
		return httpStatus.getReasonPhrase();
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
