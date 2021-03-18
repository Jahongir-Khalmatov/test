package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Currency;
import realproject.lesson11.entity.Input;
import realproject.lesson11.entity.Supplier;
import realproject.lesson11.entity.WearHouse;
import realproject.lesson11.payload.InputDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.CurrencyRepository;
import realproject.lesson11.repository.InputRepository;
import realproject.lesson11.repository.SupplierRepository;
import realproject.lesson11.repository.WearHouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WearHouseRepository wearHouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    public Result addInput(@RequestBody InputDto inputDto){
        Input input = new Input();
        input.setCode(inputDto.getCode());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setDate(inputDto.getDate());
        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("currency id not founded",false);
        Currency currency = optionalCurrency.get();
        input.setCurrency(currency);
        Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(inputDto.getWearHouseId());
        if (!optionalWearHouse.isPresent())
            return new Result("wearHouse id not founded",false);
        WearHouse wearHouse = optionalWearHouse.get();
        input.setWearHouse(wearHouse);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalCurrency.isPresent())
            return new Result("supplier Id not founded",false);
        Supplier supplier = optionalSupplier.get();
        input.setSupplier(supplier);
        inputRepository.save(input);
        return new Result("Input added",true);

}
public List<Input> getInputList(){
    List<Input> inputList = inputRepository.findAll();
    return inputList;
}
public Input getInputById(@PathVariable Integer id){
    Optional<Input> optionalInput = inputRepository.findById(id);
    if (!optionalInput.isPresent())
        return new Input();
    Input input = optionalInput.get();
    return input;
}
public Result editInput(@PathVariable Integer id,@RequestBody InputDto inputDto){
    Optional<Input> optionalInput = inputRepository.findById(id);
    if (!optionalInput.isPresent())
        return new Result("input id not founded",false);
    Input input = optionalInput.get();
    input.setCode(inputDto.getCode());
    input.setFactureNumber(inputDto.getFactureNumber());
    input.setDate(inputDto.getDate());
    Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
    if (!optionalCurrency.isPresent())
        return new Result("currency id not founded",false);
    Currency currency = optionalCurrency.get();
    input.setCurrency(currency);
    Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(inputDto.getWearHouseId());
    if (!optionalWearHouse.isPresent())
        return new Result("wearHouse id not founded",false);
    WearHouse wearHouse = optionalWearHouse.get();
    input.setWearHouse(wearHouse);
    Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
    if (!optionalCurrency.isPresent())
        return new Result("supplier Id not founded",false);
    Supplier supplier = optionalSupplier.get();
    input.setSupplier(supplier);
    inputRepository.save(input);
    return new Result("Input added",true);
}
public Result deleteInput(@PathVariable Integer id){
    Optional<Input> optionalInput = inputRepository.findById(id);
    if (optionalInput.isPresent())
        return new Result("input id not founded",false);
    Input input = optionalInput.get();
    inputRepository.delete(input);
    return new Result("input deleted",true);
}
}

