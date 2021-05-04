package int221.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int221.project.project.models.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, String> {

}
