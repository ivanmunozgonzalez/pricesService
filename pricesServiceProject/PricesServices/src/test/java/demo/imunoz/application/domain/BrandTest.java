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
import demo.imunoz.domain.model.brand.Brand;

@SpringBootTest(classes = Application.class)
@ExtendWith(MockitoExtension.class)
public class BrandTest extends Mockito {

    @Test
    public void createBrand() throws DomainException {
	var brand =
		Brand.of(1l, "ZARA");
	assertNotNull(brand.getBrandId());
    }

    @Test
    public void createBrandWithNullId() throws DomainException {
	assertThrows(DomainException.class,
		() -> Brand.of(null, "ZARA"));
    }

    @Test
    public void createBrandWithNullName() throws DomainException {
	assertThrows(DomainException.class,
		() -> Brand.of(1l, null));
    }

    @Test
    public void createBrandWithEmptyName() throws DomainException {
	assertThrows(DomainException.class,
		() -> Brand.of(1l, ""));
    }
}
