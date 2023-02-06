package demo.imunoz.infrastructure.persistence.product;

import org.springframework.stereotype.Component;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.product.Product;

@Component
public class ProductEntityMapper {

    public Product toModel(ProductEntity entity) throws DomainException {
	return Product.of(entity.getId(), entity.getName());
    }
}
