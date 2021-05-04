package int221.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int221.project.project.models.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
