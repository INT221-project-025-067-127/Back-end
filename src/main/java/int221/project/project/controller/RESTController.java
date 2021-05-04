package int221.project.project.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int221.project.project.models.Brand;
import int221.project.project.models.Image;
import int221.project.project.models.Product;
import int221.project.project.models.ProductInfo;
import int221.project.project.service.BrandService;
import int221.project.project.service.ImageService;
import int221.project.project.service.ProductInfoService;
import int221.project.project.service.ProductService;

@RestController
public class RESTController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/brands")
    public List<Brand> getAllBrand() {
        return brandService.getAll();
    }

    @GetMapping("/products")
    public List<Product> getALlProduct() {
        return productService.getAll();
    }

    @GetMapping("/productsInfo")
    public List<ProductInfo> getAllProductWithInfo() {
        return productInfoService.getAll();
    }

    @PostMapping("/addProductInfo")
    public ProductInfo addProduct(@RequestBody ProductInfo product) {
        return productInfoService.create(product);
    }

    @PostMapping("/postImage")
    public Image postImage(@RequestBody Image image) {
        image.setId(UUID.randomUUID().toString());
        imageService.create(image);
        return image;
    }

    @PostMapping("/postProduct")
    public Product postProduct(@RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setBrand(brandService.getById(brandService.getIdByName(product.getBrand().getName())));
        productService.create(product);
        return product;
    }
}
