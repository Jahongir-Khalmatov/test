package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.InputProduct;
import realproject.lesson11.entity.OutputProduct;
import realproject.lesson11.payload.InputProductDto;
import realproject.lesson11.payload.OutputProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.InputProductService;
import realproject.lesson11.service.OutputProductService;
import realproject.lesson11.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;
   @GetMapping("/getList")
    public List<OutputProduct> getList(){
       return outputProductService.getList();
   }
    @GetMapping("getById/{id}")
    public OutputProduct getOutputProductById(@PathVariable Integer id){
        return outputProductService.getOutputProductById(id);
    }
    @PostMapping("/add")
    public Result addInputProduct(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.addOutputProduct(outputProductDto);
    }
    @PutMapping("/edit/{id}")
    public Result editInputProduct(@PathVariable Integer id,@RequestBody OutputProductDto outputProductDto){
        return outputProductService.editOutputProduct(id, outputProductDto);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteInputProduct(@PathVariable Integer id){
        return outputProductService.deleteOutputProduct(id);
    }

}
