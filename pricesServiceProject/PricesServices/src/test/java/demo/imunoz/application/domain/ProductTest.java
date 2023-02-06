package demo.imunoz.application.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import demo.imunoz.Application;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.product.Product;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class ProductTest extends Mockito {

    @Test
    public void createProduct() throws DomainException {
	var product =
		Product.of(1l, "T-shirt");
	assertNotNull(product.getProductId());
    }

    @Test
    public void createProductWithNullId() throws DomainException {
	assertThrows(DomainException.class,
		() -> Product.of(null, "T-shirt"));
    }

    @Test
    public void createProductWithNullName() throws DomainException {
	assertThrows(DomainException.class,
		() -> Product.of(1l, null));
    }

    @Test
    public void createProductWithEmptyName() throws DomainException {
	assertThrows(DomainException.class,
		() -> Product.of(1l, ""));
    }
}
