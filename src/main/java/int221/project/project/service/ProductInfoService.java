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
    @Autowired
    private QuantityService quantityService;

    public List<ProductInfo> getAll() {
        System.out.println("Run");
        return repository.findAll();
    }

    public ProductInfo create(ProductInfo product) {
        String productId = UUID.randomUUID().toString();
        String brandId = brandService.getIdByName(product.getBrand().getName());

        product.setProductId(productId);
        product.setBrandId(brandId);
        product.getBrand().setId(brandId);

        Product newProduct = new Product(productId, product.getName(), product.getPrice(), product.getReleaseDate(),
                product.getDescription(), brandService.getByName(product.getBrand().getName()));
        productService.create(newProduct);

        for (Image image : product.getImages()) {
            image.setId(UUID.randomUUID().toString());
            image.setProductId(productId);
            imageService.create(image);
        }

        for (Quantity quantity : product.getQuantity()) {
            String colorId = colorService.getIdByName(quantity.getColor().getName());
            String sizeId = sizeService.getIdByName(quantity.getSize().getSize());
            quantity.setId(new ProductDetailId(colorId, productId, sizeId));
            quantity.getColor().setId(colorId);
            quantity.getSize().setId(sizeId);
            quantityService.create(quantity);
        }
        return product;
    }

    public ProductInfo getById(String id) {
        List<ProductInfo> products = repository.findAll();
        for (ProductInfo productInfo : products) {
            if (productInfo.getProductId().equals(id)) {
                return productInfo;
            }
        }
        return null;
    }
}
