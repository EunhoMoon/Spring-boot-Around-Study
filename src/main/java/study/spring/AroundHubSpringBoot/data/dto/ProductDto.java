package study.spring.AroundHubSpringBoot.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull
//	@Size(min = 8, max = 8)
	private String productId;
	
	@NotNull
	private String productName;
	
	@NotNull
	@Min(500)
	@Max(3000000)
	private int productPrice;
	
	@NotNull
	@Min(0)
	@Max(9999)
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