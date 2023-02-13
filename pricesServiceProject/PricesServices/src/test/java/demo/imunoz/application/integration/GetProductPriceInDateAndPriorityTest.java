package demo.imunoz.application.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import demo.imunoz.Application;
import demo.imunoz.application.service.productPrice.useCase.GetProductPriceInDateAndPriority;
import demo.imunoz.domain.exception.DateFormatException;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class GetProductPriceInDateAndPriorityTest extends Mockito {

	private final String DATE_NOW = "2022-06-16T21:00:00";
	private final Long PRODUCT_ID_FAIL = 1l;

	private final String DATE_IN_RANGE = "2020-06-15T10:00:00";
	private final Long PRODUCT_ID = 35455l;
	private final Long BRAND_ID = 1l;

	@Autowired
	private GetProductPriceInDateAndPriority tested;

	@Test
	public void findPriceByIdProductIdBrandAndApplicationDateOrderPriorityDescNotFound()
			throws EntityNotFoundException, DomainException, DateFormatException {
		assertThrows(EntityNotFoundException.class, () -> tested.execute(PRODUCT_ID_FAIL, BRAND_ID, DATE_NOW));
	}

	@Test
	public void findPriceByIdProductIdBrandAndApplicationDateOrderPriorityDescFound()
			throws EntityNotFoundException, DomainException, DateFormatException {
		assertNotNull(tested.execute(PRODUCT_ID, BRAND_ID, DATE_IN_RANGE));
	}
}
