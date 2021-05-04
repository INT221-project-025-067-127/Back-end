package int221.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int221.project.project.models.Color;
import int221.project.project.repositories.ColorRepository;

@Service
public class ColorService {
    @Autowired
    private ColorRepository repository;

    public Color getById(String id) {
        return repository.getOne(id);
    }

    public String getIdByName(String name) {
        List<Color> colors = repository.findAll();
        for (Color color : colors) {
            if (color.getName().equals(name)) {
                return color.getId();
            }
        }
        return null;
    }
}
