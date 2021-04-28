package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.ProductDetail;
import int221.project.project.repositories.ProductDetailRepository;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository repository;

    public List<ProductDetail> getAll() {
        return repository.findAll();
    }
}
