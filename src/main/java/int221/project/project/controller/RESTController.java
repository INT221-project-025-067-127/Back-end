package int221.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.project.project.models.Brand;
import int221.project.project.models.Product;
import int221.project.project.models.ProductDetail;
import int221.project.project.service.BrandService;
import int221.project.project.service.ProductDetailService;
import int221.project.project.service.ProductService;

@RestController
public class RESTController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/brands")
    public List<Brand> getAllBrand() {
        return brandService.getAll();
    }

    @GetMapping("/products")
    public List<Product> getALlProduct() {
        return productService.getAll();
    }

    @GetMapping("/productdetails")
    public List<ProductDetail> getAllProductWithDetail() {
        return productDetailService.getAll();
    }
}
