package demo.imunoz.application.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import demo.imunoz.Application;
import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.brand.Brand;
import demo.imunoz.domain.model.product.Product;
import demo.imunoz.domain.model.productPrice.ProductPrice;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class ProductPriceTest extends Mockito {

    private Product product;
    private Brand brand;

    @BeforeEach
    void setUp() throws DomainException {
	product = Product.of(1l, "T-shirt");
	brand = Brand.of(1l, "ZARA");
    }

    @Test
    public void createProductPrice() throws DomainException {
	var productPrice =
		ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), 1l, 1l, 35.0, "EUR", brand);
	assertNotNull(productPrice.getProduct());
	assertNotNull(productPrice.getBrand());
    }

    @Test
    public void createProductPriceWithNullProduct() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(null, LocalDateTime.now(), LocalDateTime.now(), 1l, 1l, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullStartDate() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, null, LocalDateTime.now(), 1l, 1l, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullEndDate() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), null, 1l, 1l, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithStartDateAfterEndDate() throws DomainException {
	assertThrows(DomainException.class, () -> ProductPrice.of(product, LocalDateTime.now().plusDays(1),
		LocalDateTime.now(), 1l, 1l, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullPriceList() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), null, 1l, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullPriority() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), 1l, null, 35.0, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullPrice() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), 1l, 1l, null, "EUR", brand));
    }

    @Test
    public void createProductPriceWithNullCurr() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), 1l, 1l, 35.0, null, brand));
    }

    @Test
    public void createProductPriceWithNullBrand() throws DomainException {
	assertThrows(DomainException.class,
		() -> ProductPrice.of(product, LocalDateTime.now(), LocalDateTime.now(), 1l, 1l, 35.0, "EUR", null));
    }

}
