package int221.project.project.controller;

import java.util.ArrayList;
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
import int221.project.project.models.ProductDetailId;
import int221.project.project.models.ProductInfo;
import int221.project.project.models.Quantity;
import int221.project.project.service.BrandService;
import int221.project.project.service.ColorService;
import int221.project.project.service.ProductInfoService;
import int221.project.project.service.ProductService;
import int221.project.project.service.SizeService;

@RestController
public class RESTController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;

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
}
