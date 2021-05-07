package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.ProductDetailId;
import int221.project.project.models.Quantity;
import int221.project.project.repositories.QuantityRepository;

@Service
public class QuantityService {
    @Autowired
    private QuantityRepository repository;

    public List<Quantity> getAll() {
        return repository.findAll();
    }

    public Quantity create(Quantity quantity) {
        repository.save(quantity);
        return quantity;
    }

    public void delete(ProductDetailId id) {
        repository.deleteById(id);
    }
}
