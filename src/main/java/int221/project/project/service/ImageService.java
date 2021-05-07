package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.Image;
import int221.project.project.repositories.ImageRepository;

@Service
public class ImageService {
    @Autowired
    private ImageRepository repository;

    public List<Image> getAll() {
        return repository.findAll();
    }

    public Image create(Image image) {
        repository.save(image);
        return image;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
