package demo.imunoz.domain.model.productPrice;

import java.time.LocalDateTime;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;
import demo.imunoz.domain.model.CommonRepository;
import demo.imunoz.domain.model.productPrice.property.ProductPriceId;

public interface ProductPriceRepository extends CommonRepository<ProductPrice, ProductPriceId> {

    ProductPrice findProductPriceByDateAndPriority(LocalDateTime applicationDate, Long productId, Long brandId)
	    throws EntityNotFoundException, DomainException;
}