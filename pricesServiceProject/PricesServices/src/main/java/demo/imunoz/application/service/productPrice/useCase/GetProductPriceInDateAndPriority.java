package demo.imunoz.application.service.productPrice.useCase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.application.service.productPrice.ProductPriceMapper;
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
    public ProductPriceDTO execute(Long productId, Long brandId, LocalDateTime applicationDate)
	    throws DomainException, EntityNotFoundException {
	ProductPrice productPrice =
		productPriceRepository.findFirstProductPriceByDateOrderByPriority(applicationDate, productId, brandId);
	return productPriceMapper.toDTO(productPrice);
    }

}
