package demo.imunoz.infrastructure.persistence.brand;

import org.springframework.stereotype.Component;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.brand.Brand;

@Component
public class BrandEntityMapper {

    public Brand toModel(BrandEntity entity) throws DomainException {
	return Brand.of(entity.getId(), entity.getName());
    }
}
