package demo.imunoz.infrastructure.persistence.productPrice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;
import demo.imunoz.domain.model.productPrice.ProductPrice;
import demo.imunoz.domain.model.productPrice.ProductPriceRepository;
import demo.imunoz.infrastructure.persistence.productPrice.ProductPriceEntity;
import demo.imunoz.infrastructure.persistence.productPrice.ProductPriceEntityMapper;

@Repository
public class ProductPriceH2Repository implements ProductPriceRepository {

    private final ProductPriceJPARepository productPriceJPARepository;

    private final ProductPriceEntityMapper productPriceEntityMapper;

    @Autowired
    public ProductPriceH2Repository(final ProductPriceJPARepository productPriceJPARepository,
	    ProductPriceEntityMapper productPriceEntityMapper) {
	this.productPriceJPARepository = productPriceJPARepository;
	this.productPriceEntityMapper = productPriceEntityMapper;
    }

    public ProductPrice findProductPriceByDateAndPriority(LocalDateTime applicationDate, Long productId, Long brandId)
	    throws EntityNotFoundException, DomainException {
	List<ProductPriceEntity> productPricesEntity = productPriceJPARepository
		.findProductPriceByProductAndBrandBetweenDate(applicationDate, productId, brandId);
	if (!productPricesEntity.isEmpty()) {
	    return productPriceEntityMapper.toModel(productPricesEntity.get(0));
	} else {
	    throw EntityNotFoundException.of(ProductPriceEntity.class.getName());
	}
    }

}
