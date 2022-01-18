package study.spring.AroundHubSpringBoot.service.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import study.spring.AroundHubSpringBoot.dto.MemberDTO;
import study.spring.AroundHubSpringBoot.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

	@Override
	public String getAroundHub() {
		URI uri = UriComponentsBuilder	// 어떤 경로로 요청할지 
				.fromUriString("http://localhost:9090")
				.path("/api/server/around-hub")
				.encode()	// default = utf-8
				.build()	// 값들을 넣는 작업
				.toUri();	// build의 리턴값 UriComponents를 uri형태로 형변환
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		LOGGER.info("status code : {}", responseEntity.getStatusCode());
		LOGGER.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public String getName() {
		URI uri = UriComponentsBuilder	// 어떤 경로로 요청할지 
				.fromUriString("http://localhost:9090")
				.path("/api/server/name")
				.queryParam("name", "Eunho")	// requestParam에 key값과 value 값을 넣어준다.
				.encode()	// default = utf-8
				.build()	// 값들을 넣는 작업
				.toUri();	// build의 리턴값 UriComponents를 uri형태로 형변환
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		LOGGER.info("status code : {}", responseEntity.getStatusCode());
		LOGGER.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public String getName2() {
		URI uri = UriComponentsBuilder	// 어떤 경로로 요청할지 
				.fromUriString("http://localhost:9090")
				.path("/api/server/path-variable/{name}")
				.encode()			// default = utf-8
				.build()			// 값들을 넣는 작업
				.expand("Eunho")	// 복수의 값을 넣어야할 경우 ', '를 추가하여 구분
				.toUri();			// build의 리턴값 UriComponents를 uri형태로 형변환
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		LOGGER.info("status code : {}", responseEntity.getStatusCode());
		LOGGER.info("body : {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public ResponseEntity<MemberDTO> postDto() {
		URI uri = UriComponentsBuilder	// 어떤 경로로 요청할지 
				.fromUriString("http://localhost:9090")
				.path("/api/server/member")
				.queryParam("name", "Eunho")		
				.queryParam("email", "test@g.com")
				.queryParam("organization", "Home")
				.encode()
				.build()
				.toUri();
				
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("Eunho!!");
		memberDTO.setEmail("test@gmail.com");
		memberDTO.setOrganization("Home Sweet Home!");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);
		
		LOGGER.info("status code : {}", responseEntity.getStatusCode());
		LOGGER.info("body : {}", responseEntity.getBody());
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<MemberDTO> addHeader() {
		URI uri = UriComponentsBuilder	// 어떤 경로로 요청할지 
				.fromUriString("http://localhost:9090")
				.path("/api/server/add-header")
				.encode()			// default = utf-8
				.build()			// 값들을 넣는 작업
				.toUri();			// build의 리턴값 UriComponents를 uri형태로 형변환
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("Eunho");
		memberDTO.setEmail("test@g.com");
		memberDTO.setOrganization("Home Sweet Home");
		
		RequestEntity<MemberDTO> requestEntity = RequestEntity
				.post(uri)
				.header("around-header", "Around Hub Studio")
				.body(memberDTO);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);
				
		LOGGER.info("status code : {}", responseEntity.getStatusCode());
		LOGGER.info("body : {}", responseEntity.getBody());
		
		return responseEntity;
	}

}
