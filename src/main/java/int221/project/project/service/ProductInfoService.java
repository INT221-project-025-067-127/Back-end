package int221.project.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private FileService fileService;

    public List<ProductInfo> getAll() {
        System.out.println("Run");
        return repository.findAll();
    }

    public ProductInfo create(ProductInfo product, MultipartFile[] files) {
        List<String> filesname = fileService.upload(files);
        List<Image> images = new ArrayList<>();
        String productId = product.getProductId();

        for (String filename : filesname) {
            Image newImage = new Image(UUID.randomUUID().toString(), filename, productId);
            images.add(newImage);
        }
        product.setImages(images);
        product.setProductId(UUID.randomUUID().toString());

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

    public ProductInfo edit(ProductInfo product, MultipartFile[] files) {
        delete(product.getProductId());
        create(product, files);
        return product;

    }

    public ProductInfo getById(String id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Product Not found");
        }

    }

    public ProductInfo delete(String id) {
        ProductInfo product = repository.getOne(id);

        for (Quantity quantity : product.getQuantity()) {
            quantityService.delete(quantity.getId());
        }
        for (Image image : product.getImages()) {
            imageService.delete(image.getId());
            fileService.deleteFile(image.getImageName());
        }

        productService.delete(id);
        return product;
    }
}
