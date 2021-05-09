package int221.project.project.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import int221.project.project.exception.ExceptionResponse;
import int221.project.project.exception.ProductException;
import int221.project.project.models.Brand;
import int221.project.project.models.Color;
import int221.project.project.models.Image;
import int221.project.project.models.Product;
import int221.project.project.models.ProductInfo;
import int221.project.project.models.Size;
import int221.project.project.service.BrandService;
import int221.project.project.service.ColorService;
import int221.project.project.service.FileService;
import int221.project.project.service.ProductInfoService;
import int221.project.project.service.ProductService;
import int221.project.project.service.SizeService;

@RestController
@CrossOrigin(origins = "*")
public class RESTController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ColorService colorService;

    @GetMapping("/api/brands")
    public List<Brand> getAllBrand() {
        return brandService.getAll();
    }

    @GetMapping("/api/sizes")
    public List<Size> getAllSize() {
        return sizeService.getALl();
    }

    @GetMapping("/api/colors")
    public List<Color> getAllColors() {
        return colorService.getAll();
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
    public void addProduct(@RequestPart ProductInfo product, @RequestParam("files") MultipartFile[] files) {
        product.setProductId(UUID.randomUUID().toString());
        productInfoService.create(product, files);
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable String id) {
        productInfoService.delete(id);
    }

    @PutMapping("/api/product/{id}")
    public ProductInfo editProduct(@PathVariable String id, @RequestPart ProductInfo product,
            @RequestParam("files") MultipartFile[] files) {
        product.setProductId(id);
        return productInfoService.edit(product, files);
    }

    // @GetMapping("/api/exception")
    // public void getException() {
    // throw new ProductException(ExceptionResponse.ERROR_CODE.FILE_ALREADY_EXIST,
    // "file is already exists");
    // }

}
