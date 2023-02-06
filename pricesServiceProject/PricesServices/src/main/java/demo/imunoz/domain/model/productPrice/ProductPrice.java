package demo.imunoz.domain.model.productPrice;

import java.time.LocalDateTime;

import demo.imunoz.domain.exception.DomainException;
import demo.imunoz.domain.model.brand.Brand;
import demo.imunoz.domain.model.product.Product;
import demo.imunoz.domain.model.productPrice.property.ProductPriceId;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ProductPrice {

    private ProductPriceId productPriceId;
    private Product product;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long priority;
    private Double price;
    private String curr;
    private Brand brand;

    @Getter(AccessLevel.NONE)
    private final String PRODUCT_NAME = "product";
    @Getter(AccessLevel.NONE)
    private final String STARTDATE_NAME = "startDate";
    @Getter(AccessLevel.NONE)
    private final String ENDDATE_NAME = "endDate";
    @Getter(AccessLevel.NONE)
    private final String STARTDATE_ENDDATE_NAME = "startDate and endDate";
    @Getter(AccessLevel.NONE)
    private final String PRICELIST_NAME = "priceList";
    @Getter(AccessLevel.NONE)
    private final String PRIORITY_NAME = "priority";
    @Getter(AccessLevel.NONE)
    private final String PRICE_NAME = "price";
    @Getter(AccessLevel.NONE)
    private final String CURR_NAME = "curr";
    @Getter(AccessLevel.NONE)
    private final String BRAND_NAME = "brand";

    private ProductPrice(Product product, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long priority,
	    Double price, String curr, Brand brand) throws DomainException {
	if (product == null) {
	    throw DomainException.of(this.getClass().getName(), PRODUCT_NAME);
	}
	if (startDate == null) {
	    throw DomainException.of(this.getClass().getName(), STARTDATE_NAME);
	}
	if (endDate == null) {
	    throw DomainException.of(this.getClass().getName(), ENDDATE_NAME);
	}
	if (startDate.isAfter(endDate)) {
	    throw DomainException.of(this.getClass().getName(), STARTDATE_ENDDATE_NAME);
	}
	if (priceList == null) {
	    throw DomainException.of(this.getClass().getName(), PRICELIST_NAME);
	}
	if (priority == null) {
	    throw DomainException.of(this.getClass().getName(), PRIORITY_NAME);
	}
	if (price == null) {
	    throw DomainException.of(this.getClass().getName(), PRICE_NAME);
	}
	if (curr == null) {
	    throw DomainException.of(this.getClass().getName(), CURR_NAME);
	}
	if (brand == null) {
	    throw DomainException.of(this.getClass().getName(), BRAND_NAME);
	}

	this.product = product;
	this.startDate = startDate;
	this.endDate = endDate;
	this.priceList = priceList;
	this.priority = priority;
	this.price = price;
	this.curr = curr;
	this.brand = brand;
    }

    public static ProductPrice of(Product product, LocalDateTime startDate, LocalDateTime endDate, Long priceList,
	    Long priority, Double price, String curr, Brand brand) throws DomainException {
	return new ProductPrice(product, startDate, endDate, priceList, priority, price, curr, brand);
    }
}
