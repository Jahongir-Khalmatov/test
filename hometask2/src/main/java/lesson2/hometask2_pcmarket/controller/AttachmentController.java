package lesson2.hometask2_pcmarket.controller;

import lesson2.hometask2_pcmarket.entity.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import lesson2.hometask2_pcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/{id}")
    public void getById(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentService.getById(id,response);
    }

    @PostMapping
    public Attachment add(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.add(request);
    }

    @DeleteMapping
    public void deleteById(Integer id){
        attachmentService.deleteById(id);
    }
}
