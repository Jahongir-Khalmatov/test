package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Category;
import realproject.lesson11.payload.CategoryDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getList(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }
    public Category getById(@PathVariable Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Category();
        Category category = optionalCategory.get();
        return category;
    }
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        boolean exists = categoryRepository.existsByName(categoryDto.getName());
        if (exists)
            return new Result("this category name already exists",false);
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        Integer categoryId = categoryDto.getCategoryId();
        if (categoryId!=null) {
            Optional<Category> optionalCategory;
            optionalCategory = categoryRepository.findById(categoryDto.getCategoryId());
            if (!optionalCategory.isPresent())
                return new Result("no", false);
            Category category1 = optionalCategory.get();
            category.setParentCategory(category1);
            categoryRepository.save(category);}
            return new Result("category added", true);
    }
    public Result editCategory(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("category id not founded",false);
        Category category = optionalCategory.get();
        boolean exists = categoryRepository.existsByName(categoryDto.getName());
        if (exists)
            return new Result("category name already exists",false);
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        Integer categoryId = categoryDto.getCategoryId();
        if (categoryId!=null){
            Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getCategoryId());
            if (!categoryOptional.isPresent())
                return new Result("category id not founded",false);
            Category category1 = categoryOptional.get();
            category.setParentCategory(category1);
            categoryRepository.save(category);
        }
        return new Result("category edited",true);
    }
    public Result delete(@PathVariable Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("category id not founded",false);
        Category category = optionalCategory.get();
        categoryRepository.delete(category);
        return new Result("category deleted",true);
    }
}
