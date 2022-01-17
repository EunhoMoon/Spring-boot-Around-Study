package study.spring.AroundHubSpringBoot.service;

import study.spring.AroundHubSpringBoot.data.dto.ProductDto;

public interface ProductService {

	  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

	  ProductDto getProduct(String productId);
}
