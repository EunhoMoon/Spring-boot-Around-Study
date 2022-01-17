package study.spring.AroundHubSpringBoot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
