package web.varlamov.dockerimagedemo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
  @GetMapping
  public ResponseEntity<?> get() throws IOException {
    System.out.println("Handle new request: " + System.currentTimeMillis());
    File videoFile = ResourceUtils.getFile("classpath:static/video.mp4");
    byte[] imageBytes = Files.readAllBytes(videoFile.toPath());

    return ResponseEntity.status(HttpStatus.OK)
        .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"video.mp4\"")
        .contentType(new MediaType("video", "mp4"))
        .body(imageBytes);
  }
}
