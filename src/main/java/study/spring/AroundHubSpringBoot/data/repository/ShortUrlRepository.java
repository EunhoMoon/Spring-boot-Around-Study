package study.spring.AroundHubSpringBoot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.AroundHubSpringBoot.data.entity.ShortUrlEntity;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

	ShortUrlEntity findByUrl(String url);
	
	ShortUrlEntity findByOrgUrl(String originalUrl);
	
}
