package study.spring.AroundHubSpringBoot.service;

import study.spring.AroundHubSpringBoot.data.dto.ProductDto;

public interface ProductService {

	  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
	  // 받은 값들을 DB에 저장하는 메소드 
	  
	  ProductDto getProduct(String productId);
	  // Id 값을 통해 상품 정보를 받아오는 메소드
}
