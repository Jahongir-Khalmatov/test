package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Product;
import realproject.lesson11.payload.ProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/getList")
    public List<Product> getList(){
        List<Product> list = productService.getList();
        return list;
    }
    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable Integer id){
        Product byId = productService.getById(id);
        return byId;
    }
    @PostMapping("/add")
    public Result add(@RequestBody ProductDto productDto){
        Result result = productService.add(productDto);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Result result = productService.edit(id, productDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result delete = productService.delete(id);
        return delete;
    }
}
