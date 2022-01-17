package study.spring.AroundHubSpringBoot.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.spring.AroundHubSpringBoot.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {
// DB의 table과 직접적으로 매핑되는 클래스

  @Id
  String productId;

  String productName;

  Integer productPrice;

  Integer productStock;

  /*
  @Column
  String sellerId;
  @Column
  String sellerPhoneNumber;
   */

  public ProductDto toDto(){
    return ProductDto.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
  }
}