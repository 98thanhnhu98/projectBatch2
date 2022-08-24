package com.example.Project.view;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImgUploadController {
    @RequestMapping(value = "image/{thumbnail}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("thumbnail") String thumbnail){
        if (!thumbnail.equals("")|| thumbnail != null){
            try {
                Path filename = Paths.get("src/main/resources/static/uploads",thumbnail);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/jpg"))
                        .body(byteArrayResource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
