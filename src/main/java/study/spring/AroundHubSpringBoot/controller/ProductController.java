package study.spring.AroundHubSpringBoot.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.spring.AroundHubSpringBoot.data.dto.ProductDto;
import study.spring.AroundHubSpringBoot.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService){
	  this.productService = productService;
	}
	
	// http://localhost:8080/api/v1/product-api/product/{productId}
	@GetMapping(value = "/product/{productId}")
	public ProductDto getProduct(@PathVariable String productId) {
	  return productService.getProduct(productId);
	}
	
	// http://localhost:8080/api/v1/product-api/product
	@PostMapping(value = "/product")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
	
	  String productId = productDto.getProductId();
	  String productName = productDto.getProductName();
	  int productPrice = productDto.getProductPrice();
	  int productStock = productDto.getProductStock();
	  
	  ProductDto response = productService
			  .saveProduct(productId, productName, productPrice, productStock);
	  
	  LOGGER.info(
			  "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
			  response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());
	
	  return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	// http://localhost:8080/api/v1/product-api/product/{productId}
	@DeleteMapping(value = "/product/{productId}")
	public ProductDto deleteProduct(@PathVariable String productId) {
	  return null;
	}
}