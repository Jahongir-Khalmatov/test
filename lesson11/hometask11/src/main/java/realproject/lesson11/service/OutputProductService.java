package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.*;
import realproject.lesson11.payload.InputProductDto;
import realproject.lesson11.payload.OutputProductDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
@Autowired
OutputRepository outputRepository;
public List<OutputProduct> getList(){
    List<OutputProduct> outputProductList = outputProductRepository.findAll();
    return outputProductList;
}
public OutputProduct getOutputProductById(@PathVariable Integer id){
    Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
    if (!optionalOutputProduct.isPresent())
        return new OutputProduct();
    OutputProduct outputProduct = optionalOutputProduct.get();
    return outputProduct;
}
public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto){
    OutputProduct outputProduct = new OutputProduct();
    outputProduct.setAmount(outputProduct.getAmount());
    outputProduct.setPrice(outputProduct.getPrice());
    Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getProductId());
    if (!optionalOutput.isPresent())
        return new Result("Output id not founded",false);
    Output output = optionalOutput.get();
    outputProduct.setOutput(output);
    Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
    if (!optionalProduct.isPresent())
        return new Result("product id not founded",false);
    Product product = optionalProduct.get();
    outputProduct.setProduct(product);
    outputProductRepository.save(outputProduct);
    return new Result("inputProduct added",true);
}
public Result editOutputProduct(@PathVariable Integer id,@RequestBody OutputProductDto outputProductDto){
    Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
    if (!optionalOutputProduct.isPresent())
        return new Result("Outputproduct Id not founded",false);
    OutputProduct outputProduct = new OutputProduct();
    outputProduct.setAmount(outputProduct.getAmount());
    outputProduct.setPrice(outputProduct.getPrice());
    Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getProductId());
    if (!optionalOutput.isPresent())
        return new Result("Output id not founded",false);
    Output output = optionalOutput.get();
    outputProduct.setOutput(output);
    Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
    if (!optionalProduct.isPresent())
        return new Result("product id not founded",false);
    Product product = optionalProduct.get();
    outputProduct.setProduct(product);
    outputProductRepository.save(outputProduct);
    return new Result("inputProduct added",true);
}
public Result deleteOutputProduct(@PathVariable Integer id){
    Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
    if (!optionalOutputProduct.isPresent())
        return new Result("inputProduct id not founded",false);
    OutputProduct outputProduct = optionalOutputProduct.get();
    outputProductRepository.delete(outputProduct);
    return new Result("product deleted",true);
}
}
