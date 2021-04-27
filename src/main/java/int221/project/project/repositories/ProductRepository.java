package int221.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int221.project.project.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
