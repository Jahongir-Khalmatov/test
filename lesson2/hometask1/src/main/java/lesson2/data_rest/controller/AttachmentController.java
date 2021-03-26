package lesson2.data_rest.controller;

import lesson2.data_rest.entity.Attachment;
import lesson2.data_rest.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.util.List;

@RestController @RequestMapping("/attachment")
public class AttachmentController {
@Autowired
AttachmentService attachmentService;
@PostMapping("/add")
    public Result add(MultipartHttpServletRequest request) throws IOException {
    Result result = (Result) attachmentService.uploadFileDb(request);
    return result;
}
@GetMapping("/list")
    public List<Attachment> getList(){
    List<Attachment> allAttachment = attachmentService.getAllAttachment();
    return allAttachment;
}
    @GetMapping("/getById/{id}")
    public void download(@PathVariable Integer id, HttpServletResponse response) throws IOException {
    attachmentService.getFile(id,response);
    }
}
