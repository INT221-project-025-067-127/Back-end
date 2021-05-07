package int221.project.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import int221.project.project.exception.ResponseMessage;
import int221.project.project.models.FileInfo;
import int221.project.project.models.Image;
import int221.project.project.service.FileStorageService;
import int221.project.project.service.ImageService;

@RestController
@CrossOrigin(origins = "*")
public class FileController {
    @Autowired
    private FileStorageService storageService;

    @PostMapping("/api/upload")
    public ResponseEntity<ResponseMessage> upload(@RequestParam("files") MultipartFile[] files) {
        String message = "";
        try {
            List<String> filenames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                storageService.save(file);
                filenames.add(file.getOriginalFilename());
            });

            message = "Uploaded the files successfully: " + filenames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/api/files")
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

    @GetMapping("/api/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .contentType(MediaType.IMAGE_PNG).body(file);
    }

    @DeleteMapping("/api/file/{filename}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String filename) {
        storageService.delete(filename);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("deleted; filename=\"" + filename + "\""));
    }
}
