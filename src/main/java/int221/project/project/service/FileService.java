package int221.project.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import int221.project.project.controller.FileController;
import int221.project.project.exception.ResponseMessage;
import int221.project.project.models.FileInfo;

@Service
public class FileService {
    @Autowired
    private FileStorageService storageService;

    public List<String> upload(@RequestParam("files") MultipartFile[] files) {
        String message = "";
        try {
            List<String> filenames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                storageService.save(file);
                filenames.add(file.getOriginalFilename());
            });
            return filenames;
        } catch (Exception e) {
            List<String> err = new ArrayList<>();
            err.add("แดงเฉย");
            return err;
        }
    }

    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        System.out.println("asd: " + fileInfos);

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .contentType(MediaType.IMAGE_PNG).body(file);
    }
}
