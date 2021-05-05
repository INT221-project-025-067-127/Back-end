package int221.project.project.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/api/brands")
    public List<Brand> getAllBrand() {
        return brandService.getAll();
    }

    @GetMapping("/api/products")
    public List<Product> getALlProduct() {
        return productService.getAll();
    }

    @GetMapping("/api/productsInfo")
    public List<ProductInfo> getAllProductWithInfo() {
        return productInfoService.getAll();
    }

    @GetMapping("/api/productInfo/{id}")
    public ProductInfo getById(@PathVariable String id) {
        System.out.println(id);
        return productInfoService.getById(id);
    }

    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());
        product.setBrand(brandService.getByName(product.getBrand().getName()));
        productService.create(product);
        return product;
    }

    @PostMapping("/api/productInfo")
    public ProductInfo addProduct(@RequestBody ProductInfo product) {
        return productInfoService.create(product);
    }

    @GetMapping("/api/image")
    public File getImage() {
        return null;
    }
}
