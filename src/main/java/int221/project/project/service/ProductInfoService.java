package int221.project.project.service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.Image;
import int221.project.project.models.Product;
import int221.project.project.models.ProductDetailId;
import int221.project.project.models.ProductInfo;
import int221.project.project.models.Quantity;
import int221.project.project.repositories.ProductInfoRepository;

@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoRepository repository;

    @Autowired
    private BrandService brandService;
//    @Autowired
//    private ColorService colorService;
//    @Autowired
//    private SizeService sizeService;
//    @Autowired
//    private ImageService imageService;
    @Autowired
    private ProductService productService;

    public List<ProductInfo> getAll() {
        System.out.println("Run");
        return repository.findAll();
    }

    public ProductInfo create(ProductInfo product) {
        product.setProductId("003");
        product.setName("Name");
        product.setPrice(123.1);
        product.setReleaseDate(Date.valueOf("2020-12-14"));
        product.setDescription("Description");
        product.setBrandId(product.getBrandId());
        product.setBrand(product.getBrand());
        product.setQuantity(product.getQuantity());
        return repository.save(product);
    }
}
