package demo.imunoz.infrastructure.persistence.productPrice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.imunoz.infrastructure.persistence.productPrice.ProductPriceEntity;

@Repository
public interface ProductPriceJPARepository extends JpaRepository<ProductPriceEntity, Long> {

    @Query("select pp from ProductPriceEntity pp where pp.product.id=?2 and pp.brand.id=?3 and ?1 between pp.startDate and pp.endDate order by pp.priority desc")
    List<ProductPriceEntity> findProductPriceByProductAndBrandBetweenDate(LocalDateTime applicationDate, Long productId,
	    Long brandId);
}
