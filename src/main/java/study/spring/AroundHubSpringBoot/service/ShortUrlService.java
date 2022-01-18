package study.spring.AroundHubSpringBoot.service;

import study.spring.AroundHubSpringBoot.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {

	ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl);
	
	ShortUrlResponseDto deleteByShortUrl(String shortUrl);

	ShortUrlResponseDto deleteByOriginalUrl(String originalUrl);
	
}
