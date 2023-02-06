package demo.imunoz.application.service.productPrice;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductPriceDTO {

    private ProductPriceDTO(Long productId, Long brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate,
	    Double price, String curr) {

	this.productId = productId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.priceList = priceList;
	this.price = price;
	this.curr = curr;
	this.brandId = brandId;
    }

    public static ProductPriceDTO of(Long productId, Long brandId, Long priceList, LocalDateTime startDate,
	    LocalDateTime endDate, Double price, String curr) {
	return new ProductPriceDTO(productId, brandId, priceList, startDate, endDate, price, curr);
    }

    private Long productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Double price;
    private String curr;
    private Long brandId;
}
