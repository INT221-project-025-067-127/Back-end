package int221.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.project.project.models.Brand;
import int221.project.project.service.BrandService;

@RestController
public class RESTController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand> getAllBrand() {
        return brandService.getAll();
    }
}
