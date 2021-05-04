package int221.project.project.service;

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
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;

    public List<ProductInfo> getAll() {
        return repository.findAll();
    }

    public ProductInfo create(ProductInfo product) {
        String brandId = brandService.getIdByName(product.getBrand().getName());
        String productId = UUID.randomUUID().toString();

        product.setBrandId(brandId);
        product.getBrand().setId(brandId);
        product.setProductId(productId);
        for (Image image : product.getImages()) {
            image.setId(UUID.randomUUID().toString());
        }

        for (Quantity quantity : product.getQuantity()) {
            String colorId = colorService.getIdByName(quantity.getColor().getName());
            String sizeId = sizeService.getIdByName(quantity.getSize().getSize());
            quantity.getSize().setId(sizeId);

            quantity.setId(new ProductDetailId(colorId, productId, sizeId));
        }
        // repository.save(product);
        return product;
    }
}
