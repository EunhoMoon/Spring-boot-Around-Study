package study.spring.AroundHubSpringBoot.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
// 각 계층간에 데이터를 전달해주는 역할

  private String productId;
  private String productName;
  private int productPrice;
  private int productStock;

  public ProductEntity toEntity(){
    return ProductEntity.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
  }
}