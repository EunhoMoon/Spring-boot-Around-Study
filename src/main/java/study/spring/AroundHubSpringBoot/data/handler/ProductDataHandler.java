package study.spring.AroundHubSpringBoot.data.handler;

import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;

public interface ProductDataHandler {

  ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

  ProductEntity getProductEntity(String productId);

}