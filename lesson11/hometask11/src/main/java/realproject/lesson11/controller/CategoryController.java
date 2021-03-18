package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Category;
import realproject.lesson11.payload.CategoryDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
@Autowired
    CategoryService categoryService;
@GetMapping("/getList")
    public List<Category> getList(){
        List<Category> list = categoryService.getList();
        return list;
    }
    @GetMapping("/grtById/{id}")
    public Category getById(@PathVariable Integer id){
        Category category = categoryService.getById(id);
        return category;
    }
    @PostMapping("/add")
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result edit(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(id, categoryDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = categoryService.delete(id);
        return result;
    }
}