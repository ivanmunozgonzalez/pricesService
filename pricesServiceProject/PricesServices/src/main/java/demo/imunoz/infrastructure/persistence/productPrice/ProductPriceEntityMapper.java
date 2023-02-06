package demo.imunoz.infrastructure.persistence.productPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.productPrice.ProductPrice;
import demo.imunoz.infrastructure.persistence.brand.BrandEntityMapper;
import demo.imunoz.infrastructure.persistence.product.ProductEntityMapper;

@Component
public class ProductPriceEntityMapper {

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Autowired
    private BrandEntityMapper brandEntityMapper;

    public ProductPrice toModel(ProductPriceEntity entity) throws DomainException {
	return ProductPrice.of(productEntityMapper.toModel(entity.getProduct()), entity.getStartDate(),
		entity.getEndDate(), entity.getPriceList(), entity.getPriority(), entity.getPrice(), entity.getCurr(),
		brandEntityMapper.toModel(entity.getBrand()));
    }
}
