package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Input;
import realproject.lesson11.entity.InputProduct;
import realproject.lesson11.entity.Product;
import realproject.lesson11.payload.InputProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.InputProductRepository;
import realproject.lesson11.repository.InputRepository;
import realproject.lesson11.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    InputRepository inputRepository;
@Autowired
    ProductRepository productRepository;
public List<InputProduct> getList(){
    List<InputProduct> productList = inputProductRepository.findAll();
    return productList;
}
public InputProduct getInputProductById(@PathVariable Integer id){
    Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
    if (!optionalInputProduct.isPresent())
        return new InputProduct();
    InputProduct inputProduct = optionalInputProduct.get();
    return inputProduct;
}
public Result addInputProduct(@RequestBody InputProductDto inputProductDto){
    InputProduct inputProduct = new InputProduct();
    inputProduct.setAmount(inputProductDto.getAmount());
    inputProduct.setPrice(inputProductDto.getPrice());
    inputProduct.setExpireDate(inputProductDto.getExpireDate());
    Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getProductId());
    if (!optionalInput.isPresent())
        return new Result("Input id not founded",false);
    Input input = optionalInput.get();
    inputProduct.setInput(input);
    Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
    if (!optionalInput.isPresent())
        return new Result("product id not founded",false);
    Product product = optionalProduct.get();
    inputProduct.setProduct(product);
    inputProductRepository.save(inputProduct);
    return new Result("inputProduct added",true);
}
public Result editInputProduct(@PathVariable Integer id,@RequestBody InputProductDto inputProductDto){
    Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
    if (!optionalInputProduct.isPresent())
        return new Result("inputproduct Id not founded",false);
    InputProduct inputProduct = optionalInputProduct.get();
    inputProduct.setAmount(inputProductDto.getAmount());
    inputProduct.setPrice(inputProductDto.getPrice());
    inputProduct.setExpireDate(inputProductDto.getExpireDate());
    Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getProductId());
    if (!optionalInput.isPresent())
        return new Result("Input id not founded",false);
    Input input = optionalInput.get();
    inputProduct.setInput(input);
    Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
    if (!optionalInput.isPresent())
        return new Result("product id not founded",false);
    Product product = optionalProduct.get();
    inputProduct.setProduct(product);
    inputProductRepository.save(inputProduct);
    return new Result("inputProduct added",true);
}
public Result deleteInputProduct(@PathVariable Integer id){
    Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
    if (!optionalInputProduct.isPresent())
        return new Result("inputProduct id not founded",false);
    InputProduct inputProduct = optionalInputProduct.get();
    inputProductRepository.delete(inputProduct);
    return new Result("product deleted",true);
}
}
