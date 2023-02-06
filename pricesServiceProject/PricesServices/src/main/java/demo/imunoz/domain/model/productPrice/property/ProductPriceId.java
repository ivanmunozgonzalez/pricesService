package demo.imunoz.domain.model.productPrice.property;

public class ProductPriceId {

    private Long id;

    ProductPriceId() {
    }

    private ProductPriceId(Long id) {
	this.id = id;
    }

    public static ProductPriceId of(Long id) {
	return new ProductPriceId(id);
    }

    public Long getValue() {
	return id;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;

	ProductPriceId productId = (ProductPriceId) o;

	return id != null ? id.equals(productId.id) : productId.id == null;
    }

    @Override
    public int hashCode() {
	return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
	return "ProductPriceId{" +
		"id=" + id +
		'}';
    }

}
