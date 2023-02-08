package demo.imunoz.infrastructure.controller.productPrice;

import static demo.imunoz.infrastructure.controller.Constants.BRAND_ID_PARAMETER;
import static demo.imunoz.infrastructure.controller.Constants.DATE_APPLICATION_PARAMETER;
import static demo.imunoz.infrastructure.controller.Constants.DATE_FORMAT_PRODUCT_PRICE;
import static demo.imunoz.infrastructure.controller.Constants.PRODUCT_ID_PARAMETER;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.imunoz.application.service.productPrice.ProductPriceDTO;
import demo.imunoz.application.service.productPrice.useCase.GetProductPriceInDateAndPriority;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;

@RestController
@RequestMapping("/api/productPrice")
public class ProductPriceController {

    @Autowired
    private GetProductPriceInDateAndPriority getProductPriceInDateAndPriority;

    @GetMapping(value = "/{productId}/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductPriceDTO> getProductPriceInDateAndPriority(
	    @PathVariable(value = PRODUCT_ID_PARAMETER, required = true) Long productId,
	    @PathVariable(value = BRAND_ID_PARAMETER, required = true) Long brandId,
	    @RequestParam(value = DATE_APPLICATION_PARAMETER, required = true) String applicationDate)
	    throws DomainException {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PRODUCT_PRICE);

	try {
	    LocalDateTime applicationDateFormated = LocalDateTime.parse(applicationDate, formatter);
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(getProductPriceInDateAndPriority.execute(productId, brandId, applicationDateFormated));
	} catch (EntityNotFoundException e) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} catch (DateTimeParseException e) {
	    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
    }
}
