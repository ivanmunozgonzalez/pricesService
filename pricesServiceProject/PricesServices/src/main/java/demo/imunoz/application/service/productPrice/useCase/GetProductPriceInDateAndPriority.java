package demo.imunoz.application.service.productPrice.useCase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.application.service.productPrice.ProductPriceMapper;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;
import demo.imunoz.domain.exception.MapperException;
import demo.imunoz.domain.model.productPrice.ProductPrice;
import demo.imunoz.domain.model.productPrice.ProductPriceRepository;;

@Service
public class GetProductPriceInDateAndPriority {

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private ProductPriceMapper productPriceMapper;

    public ProductPriceDTO execute(Long productId, Long brandId, LocalDateTime applicationDate)
	    throws MapperException, DomainException, EntityNotFoundException {
	ProductPrice productPrice =
		productPriceRepository.findProductPriceByDateAndPriority(applicationDate, productId, brandId);
	return productPriceMapper.toDTO(productPrice);
    }

}
