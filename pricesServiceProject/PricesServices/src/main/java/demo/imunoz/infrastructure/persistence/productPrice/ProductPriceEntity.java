package demo.imunoz.infrastructure.persistence.productPrice;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import demo.imunoz.infrastructure.persistence.brand.BrandEntity;
import demo.imunoz.infrastructure.persistence.product.ProductEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPriceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ProductPriceEntity of() {
	return new ProductPriceEntity();
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_BRAND", referencedColumnName = "ID")
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID")
    private ProductEntity product;

    @Column(name = "NU_PRICELIST")
    private Long priceList;

    @Column(name = "NU_PRIORITY")
    private Long priority;

    @Column(name = "DT_STARTDATE")
    private LocalDateTime startDate;

    @Column(name = "DT_ENDDATE")
    private LocalDateTime endDate;

    @Column(name = "NU_PRICE")
    private Double price;

    @Column(name = "TX_CURR")
    private String curr;

}