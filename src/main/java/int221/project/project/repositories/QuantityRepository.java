package int221.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int221.project.project.models.ProductDetailId;
import int221.project.project.models.Quantity;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, ProductDetailId> {

}
