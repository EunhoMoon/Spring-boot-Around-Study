package study.spring.AroundHubSpringBoot.service.impl;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import study.spring.AroundHubSpringBoot.data.dto.ProductDto;
import study.spring.AroundHubSpringBoot.data.entity.ProductEntity;
import study.spring.AroundHubSpringBoot.data.handler.impl.ProductDataHandlerImpl;

//@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})	// 어떠한 객체를 가져올지 모를 경우
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {
	
	@MockBean
	ProductDataHandlerImpl productDataHandler;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Test
	public void getProductTest() {
		// given
		Mockito.when(productDataHandler.getProductEntity("123"))
			.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.getProduct("123");
		
		Assertions.assertEquals(productDto.getProductId(), "123");
		Assertions.assertEquals(productDto.getProductName(), "pen");
		Assertions.assertEquals(productDto.getProductPrice(), 2000);
		Assertions.assertEquals(productDto.getProductStock(), 3000);
		
		verify(productDataHandler).getProductEntity("123");
	}

	@Test
	public void saveProductTest() {
		// given
		Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
			.thenReturn(new ProductEntity("123", "pen", 2000, 3000));
		
		ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);
		
		Assertions.assertEquals(productDto.getProductId(), "123");
		Assertions.assertEquals(productDto.getProductName(), "pen");
		Assertions.assertEquals(productDto.getProductPrice(), 2000);
		Assertions.assertEquals(productDto.getProductStock(), 3000);
	
		verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);
	}
}
