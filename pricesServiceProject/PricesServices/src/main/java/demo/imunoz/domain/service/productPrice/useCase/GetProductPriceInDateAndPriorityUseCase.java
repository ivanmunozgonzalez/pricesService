package demo.imunoz.domain.service.productPrice.useCase;

import java.time.LocalDateTime;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;

public interface GetProductPriceInDateAndPriorityUseCase {

    ProductPriceDTO execute(Long productId, Long brandId, LocalDateTime applicationDate)
	    throws DomainException, EntityNotFoundException;
}