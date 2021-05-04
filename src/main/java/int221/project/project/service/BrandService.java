package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.Brand;
import int221.project.project.repositories.BrandRepository;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    public List<Brand> getAll() {
        return repository.findAll();
    }

    public Brand getById(String id) {
        return repository.getOne(id);
    }

    public Brand getByName(String name) {
        List<Brand> brands = repository.findAll();
        for (Brand brand : brands) {
            if (brand.getName().equals(name)) {
                return brand;
            }
        }
        return null;
    }

    public String getIdByName(String name) {
        List<Brand> brands = repository.findAll();
        for (Brand brand : brands) {
            if (brand.getName().equals(name)) {
                return brand.getId();
            }
        }
        return null;
    }

}
