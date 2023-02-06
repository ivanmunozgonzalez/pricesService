package demo.imunoz.domain.model.brand;

import demo.imunoz.domain.exception.DomainException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Brand {

    private Long brandId;
    private String name;

    @Getter(AccessLevel.NONE)
    private final String BRANDID_NAME = "brandId";
    @Getter(AccessLevel.NONE)
    private final String NAME_NAME = "name";

    private Brand(Long brandId, String name) throws DomainException {
	if (brandId == null) {
	    throw DomainException.of(this.getClass().getName(), BRANDID_NAME);
	}
	if (name == null || name.isEmpty()) {
	    throw DomainException.of(this.getClass().getName(), NAME_NAME);
	}

	this.brandId = brandId;
	this.name = name;
    }

    public static Brand of(Long brandId, String name) throws DomainException {
	return new Brand(brandId, name);
    }

}
