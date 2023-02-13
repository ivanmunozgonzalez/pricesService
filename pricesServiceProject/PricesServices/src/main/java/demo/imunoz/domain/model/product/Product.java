package demo.imunoz.domain.model.product;

import demo.imunoz.domain.exception.DomainException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Product {

	private Long productId;
	private String name;

	@Getter(AccessLevel.NONE)
	private static final String PRODUCTID_NAME = "productId";
	@Getter(AccessLevel.NONE)
	private static final String NAME_NAME = "name";

	private Product(Long productId, String name) throws DomainException {
		if (productId == null) {
			throw DomainException.of(this.getClass().getSimpleName(), PRODUCTID_NAME);
		}
		if (name == null || name.isEmpty()) {
			throw DomainException.of(this.getClass().getSimpleName(), NAME_NAME);
		}

		this.productId = productId;
		this.name = name;
	}

	public static Product of(Long productId, String name) throws DomainException {
		return new Product(productId, name);
	}

}
