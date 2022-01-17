package study.spring.AroundHubSpringBoot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.spring.AroundHubSpringBoot.data.dto.ProductDto;
import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;
import study.spring.AroundHubSpringBoot.data.handler.ProductDataHandler;
import study.spring.AroundHubSpringBoot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  ProductDataHandler productDataHandler;

  @Autowired
  public ProductServiceImpl(ProductDataHandler productDataHandler){
    this.productDataHandler = productDataHandler;
  }

  @Override
  public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
    ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

    ProductDto productDto = new ProductDto(productEntity.getProductId(),
        productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

    return productDto;
  }

  @Override
  public ProductDto getProduct(String productId) {
    ProductEntity productEntity = productDataHandler.getProductEntity(productId);

    ProductDto productDto = new ProductDto(productEntity.getProductId(),
        productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

    return productDto;
  }
}
