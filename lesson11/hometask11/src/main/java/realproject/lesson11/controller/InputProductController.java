package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.InputProduct;
import realproject.lesson11.payload.InputProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;
   @GetMapping("/getList")
    public List<InputProduct> getList(){
        return inputProductService.getList();
    }
    @GetMapping("getById/{id}")
    public InputProduct getInputProductById(@PathVariable Integer id){
        return inputProductService.getInputProductById(id);
    }
    @PostMapping("/add")
    public Result addInputProduct(@RequestBody InputProductDto inputProductDto){
        return inputProductService.addInputProduct(inputProductDto);
    }
    @PutMapping("/edit/{id}")
    public Result editInputProduct(@PathVariable Integer id,@RequestBody InputProductDto inputProductDto){
        return inputProductService.editInputProduct(id, inputProductDto);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteInputProduct(@PathVariable Integer id){
        return inputProductService.deleteInputProduct(id);
    }

}
