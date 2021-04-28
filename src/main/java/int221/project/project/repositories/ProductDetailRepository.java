package int221.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int221.project.project.models.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {

}
