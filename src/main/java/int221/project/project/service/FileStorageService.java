package int221.project.project.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import int221.project.project.exception.ProductException;
import int221.project.project.exception.ExceptionResponse.ERROR_CODE;

@Service
public class FileStorageService {
    private final Path root = Paths.get("images");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (Exception e) {
            throw new RuntimeException("สร้างไฟล์ไม่ได้โว้ยยย");
        }
    }

    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new ProductException(ERROR_CODE.FILE_ALREADY_EXIST,
                    "file " + file.getOriginalFilename() + " is already exists");
        }
    }

    public void delete(String filename) {
        try {
            Files.delete(Path.of(root.toString() + "/" + filename));
        } catch (Exception e) {
            throw new RuntimeException("ลบไฟล์ไม่ได้อ้ะ");
        }
    }

    public Resource load(String fileName) {
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (!resource.isReadable()) {
                throw new ProductException(ERROR_CODE.FILE_ERROR, "Can't Read File");
            }
            return resource;

        } catch (Exception e) {
            throw new ProductException(ERROR_CODE.FILE_NOT_FOUND, "File Not Found");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (Exception e) {
            throw new RuntimeException("อ่านไฟล์ม่ายได้");
        }
    }
}
