package demo.imunoz.application.service.productPrice.useCase;

import static demo.imunoz.infrastructure.controller.Constants.DATE_FORMAT_PRODUCT_PRICE;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.application.service.productPrice.ProductPriceMapper;
import demo.imunoz.domain.exception.DateFormatException;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;
import demo.imunoz.domain.model.productPrice.ProductPrice;
import demo.imunoz.domain.model.productPrice.ProductPriceRepository;
import demo.imunoz.domain.service.productPrice.useCase.GetProductPriceInDateAndPriorityUseCase;

@Service
public class GetProductPriceInDateAndPriority implements GetProductPriceInDateAndPriorityUseCase {

	@Autowired
	private ProductPriceRepository productPriceRepository;

	@Autowired
	private ProductPriceMapper productPriceMapper;

	@Override
	public ProductPriceDTO execute(Long productId, Long brandId, String applicationDate)
			throws DomainException, EntityNotFoundException, DateFormatException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PRODUCT_PRICE);
		try {
			LocalDateTime applicationDateFormated = LocalDateTime.parse(applicationDate, formatter);

			ProductPrice productPrice = productPriceRepository
					.findFirstProductPriceByDateOrderByPriority(applicationDateFormated, productId, brandId);
			return productPriceMapper.toDTO(productPrice);
		} catch (DateTimeParseException e) {
			throw DateFormatException.of(applicationDate, DATE_FORMAT_PRODUCT_PRICE);
		}
	}
}
