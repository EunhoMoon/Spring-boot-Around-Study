package study.spring.AroundHubSpringBoot.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice	// 컨트롤 에서 발생하는 예외처리는 모두 이 곳에서 하겠다는 의미
public class AroundHunExceptionHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AroundHunExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		
		LOGGER.info("Advice 내 Exception 호출");
		
		Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
	}
	
	@ExceptionHandler(AroundException.class)
	public ResponseEntity<Map<String, String>> ExceptionHandler(AroundException e) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("error type", e.getHttpStatusType());
		map.put("error code", Integer.toString(e.getHttpStatusCode()));
		map.put("message", e.getMessage());
		
		return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
		
	}
	
}
