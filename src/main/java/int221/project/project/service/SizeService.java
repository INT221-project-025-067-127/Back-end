package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.Size;
import int221.project.project.repositories.SizeRepository;

@Service
public class SizeService {
    @Autowired
    private SizeRepository repository;

    public List<Size> getALl() {
        return repository.findAll();
    }

    public Size getById(String id) {
        return repository.getOne(id);
    }

    public String getIdByName(String name) {
        List<Size> sizes = repository.findAll();
        for (Size size : sizes) {
            if (size.getSize().equals(name)) {
                return size.getId();
            }
        }
        return "ชั้นหาไม่เจอ";
    }
}
