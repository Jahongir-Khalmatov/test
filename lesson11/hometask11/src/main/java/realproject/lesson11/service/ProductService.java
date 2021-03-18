package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Attachment;
import realproject.lesson11.entity.Category;
import realproject.lesson11.entity.Measurement;
import realproject.lesson11.entity.Product;
import realproject.lesson11.payload.ProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.AttachmentRepository;
import realproject.lesson11.repository.CategoryRepository;
import realproject.lesson11.repository.MeasurementRepository;
import realproject.lesson11.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    public List<Product> getList(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }
    public Product getById(@PathVariable Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return null;
        Product product = optionalProduct.get();
        return product;
    }
    public Result add(@RequestBody ProductDto productDto){
        boolean exists = productRepository.existsByCode(productDto.getCode());
        if (exists)
            return new Result("this Code already exists",false);
        Product product = new Product();
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("measurement id not founded",false);
        Measurement measurement = optionalMeasurement.get();
        product.setMeasurement(measurement);
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        if (!categoryOptional.isPresent())
            return new Result("measurement id not founded",false);
        Category category = categoryOptional.get();
        product.setCategory(category);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("photo id not founded",false);
        Attachment attachment = optionalAttachment.get();
        product.setPhoto(attachment);
        product.setCode(productDto.getCode());
        productRepository.save(product);
        return new Result("product saved",true);
    }
    public Result edit(@PathVariable Integer id,@RequestBody ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("product id not founded",false);
        Product product = optionalProduct.get();
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("measurement id not founded",false);
        Measurement measurement = optionalMeasurement.get();
        product.setMeasurement(measurement);
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        if (!categoryOptional.isPresent())
            return new Result("measurement id not founded",false);
        Category category = categoryOptional.get();
        product.setCategory(category);
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("photo id not founded",false);
        Attachment attachment = optionalAttachment.get();
        product.setPhoto(attachment);
        product.setCode(productDto.getCode());
        productRepository.save(product);
        return new Result("product saved",true);
    }
    public Result delete(@PathVariable Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("product id not founded",false);
        Product product = optionalProduct.get();
        productRepository.delete(product);

        return new Result("product deleted",true);
    }
}
