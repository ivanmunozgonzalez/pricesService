package demo.imunoz.application.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import demo.imunoz.Application;
import demo.imunoz.application.service.productPrice.useCase.GetProductPriceInDateAndPriority;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.exception.EntityNotFoundException;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class GetProductPriceInDateAndPriorityTest extends Mockito {

    private final LocalDateTime DATE_NOW = LocalDateTime.now();
    private final Long PRODUCT_ID_FAIL = 1l;

    private final LocalDateTime DATE_IN_RANGE = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
    private final Long PRODUCT_ID = 35455l;
    private final Long BRAND_ID = 1l;

    @Autowired
    private GetProductPriceInDateAndPriority tested;

    @Test
    public void findPriceByIdProductIdBrandAndApplicationDateOrderPriorityDescNotFound()
	    throws EntityNotFoundException, DomainException {
	assertThrows(EntityNotFoundException.class, () -> tested.execute(PRODUCT_ID_FAIL, BRAND_ID, DATE_NOW));
    }

    @Test
    public void findPriceByIdProductIdBrandAndApplicationDateOrderPriorityDescFound()
	    throws EntityNotFoundException, DomainException {
	assertNotNull(tested.execute(PRODUCT_ID, BRAND_ID, DATE_IN_RANGE));
    }
}
