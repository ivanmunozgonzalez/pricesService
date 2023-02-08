package demo.imunoz.domain.model.productPrice.property;

import lombok.Data;

@Data
public class ProductPriceId {

    private Long id;

    private ProductPriceId(Long id) {
	this.id = id;
    }

    public static ProductPriceId of(Long id) {
	return new ProductPriceId(id);
    }

}
