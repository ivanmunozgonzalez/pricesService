package demo.imunoz.application.service.productPrice;

import org.springframework.stereotype.Component;

import demo.imunoz.domain.model.productPrice.ProductPrice;

@Component
public class ProductPriceMapper {

    public ProductPriceDTO toDTO(ProductPrice model) {

	return ProductPriceDTO.of(model.getProduct().getProductId(), model.getBrand().getBrandId(),
		model.getPriceList(), model.getStartDate(), model.getEndDate(), model.getPrice(), model.getCurr());
    }

}
