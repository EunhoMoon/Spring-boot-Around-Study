package study.spring.AroundHubSpringBoot.data.dao;

import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;

public interface ProductDAO {
	
	ProductEntity saveProduct(ProductEntity productEntity);
	
	ProductEntity getProduct(String productId);
	
}
