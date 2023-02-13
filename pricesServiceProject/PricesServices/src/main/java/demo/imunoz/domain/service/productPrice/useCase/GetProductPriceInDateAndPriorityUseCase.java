package demo.imunoz.domain.service.productPrice.useCase;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.domain.exception.DateFormatException;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;

public interface GetProductPriceInDateAndPriorityUseCase {

	ProductPriceDTO execute(Long productId, Long brandId, String applicationDate)
			throws DomainException, EntityNotFoundException, DateFormatException;
}