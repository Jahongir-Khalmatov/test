package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import realproject.lesson11.entity.Attachment;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController @RequestMapping("/attachment")
public class AttachmentController {
@Autowired
    AttachmentService attachmentService;
@PostMapping("/add")
    public Result add(MultipartHttpServletRequest request) throws IOException {
    Result result = attachmentService.uploadFileDb(request);
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
