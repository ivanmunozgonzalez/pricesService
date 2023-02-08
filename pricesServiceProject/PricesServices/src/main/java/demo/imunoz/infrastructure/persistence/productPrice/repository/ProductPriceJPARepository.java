package demo.imunoz.infrastructure.persistence.productPrice.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.imunoz.infrastructure.persistence.productPrice.ProductPriceEntity;

@Repository
public interface ProductPriceJPARepository extends JpaRepository<ProductPriceEntity, Long> {

    ProductPriceEntity
	    findTop1ByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
		    Long productId,
		    Long brandId,
		    LocalDateTime applicationDate,
		    LocalDateTime sameApplicationDate);
}
