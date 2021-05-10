package int221.project.project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://52.163.222.28/")
public class TestController {
    @GetMapping
    public String get() {
        return "get";
    }

    @PostMapping
    public String post() {
        return "post";
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public String delete() {
        return "delete";
    }
}
