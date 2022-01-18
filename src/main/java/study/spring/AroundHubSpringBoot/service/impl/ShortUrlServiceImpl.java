package study.spring.AroundHubSpringBoot.service.impl;

import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import study.spring.AroundHubSpringBoot.controller.ShortUrlController;
import study.spring.AroundHubSpringBoot.data.dao.ShortUrlDAO;
import study.spring.AroundHubSpringBoot.data.dto.NaverUriDto;
import study.spring.AroundHubSpringBoot.data.dto.ShortUrlResponseDto;
import study.spring.AroundHubSpringBoot.data.entity.ShortUrlEntity;
import study.spring.AroundHubSpringBoot.service.ShortUrlService;

public class ShortUrlServiceImpl implements ShortUrlService {

	private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);
	
	@Override
	public ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl) {
		
		LOGGER.info("[generateShortUrl] request data : {}", originalUrl);
		
		ResponseEntity<NaverUriDto> responseEntity = requestShortUrl(clientId, clientSecret, originalUrl);
	
		String orgUrl = responseEntity.getBody().getResult().getOrgUrl();
		String shortUrl = responseEntity.getBody().getResult().getUrl();
		String hash = responseEntity.getBody().getResult().getHash();
		
		ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
		shortUrlEntity.setOrgUrl(orgUrl);
		shortUrlEntity.setUrl(shortUrl);
		shortUrlEntity.setHash(hash);
		
		ShortUrlDAO.saveShortUrl(shortUrlEntity);
		
		ShortUrlResponseDto shortUrlResponseDto = new ShortUrlResponseDto(orgUrl, shortUrl);
		LOGGER.info("[generateShortUrl] Response DTO : {}", shortUrlResponseDto.toString());
		return shortUrlResponseDto;
	
	}

	@Override
	public ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortUrlResponseDto deleteByShortUrl(String shortUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShortUrlResponseDto deleteByOriginalUrl(String originalUrl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ResponseEntity<NaverUriDto> requestShortUrl(String clientId, String clientSecret, String originalUrl) {
		LOGGER.info("[requestShortUrl] client ID : ***, client Secret : ***, original URL : {}", originalUrl);
		
		URI uri = UriComponentsBuilder
				.fromUriString("http://openapi.naver.com")
				.path("/v1/util/shorturl")
				.queryParam("url", originalUrl)
				.encode()
				.build()
				.toUri();
		
		LOGGER.info("[requestShortUrl] set HTTP Request Header");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Naver-Client-Id", clientId);
		headers.set("X-Naver-Client-Secret", clientSecret);
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		LOGGER.info("[requestShortUrl] request by restTemplate");
		ResponseEntity<NaverUriDto> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, NaverUriDto.class);
		
		LOGGER.info("[requestShortUrl] request has been successfully complete.");
		
		return responseEntity;
	}
	
}
