package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.*;
import realproject.lesson11.payload.InputDto;
import realproject.lesson11.payload.OutputDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WearHouseRepository wearHouseRepository;
            @Autowired
            ClientRepository clientRepository;
    SupplierRepository supplierRepository;
    public Result addOutput(@RequestBody OutputDto outputDto){
        Output output = new Output();
        output.setCode(outputDto.getCode());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setDate(outputDto.getDate());
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("currency id not founded",false);
        Currency currency = optionalCurrency.get();
        output.setCurrency(currency);
        Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(outputDto.getWearHouseId());
        if (!optionalWearHouse.isPresent())
            return new Result("wearHouse id not founded",false);
        WearHouse wearHouse = optionalWearHouse.get();
        output.setWearHouse(wearHouse);
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (!optionalCurrency.isPresent())
            return new Result("client Id not founded",false);
        Client client = optionalClient.get();
        output.setClient(client);
        outputRepository.save(output);
        return new Result("Input added",true);

}
public List<Output> getOutputList(){
    List<Output> outputList = outputRepository.findAll();
    return outputList;
}
public Output getOutputById(@PathVariable Integer id){
    Optional<Output> optionalOutput = outputRepository.findById(id);
    if (!optionalOutput.isPresent())
        return new Output();
    Output output = optionalOutput.get();
    return output;
}
public Result editOutput(@PathVariable Integer id,@RequestBody OutputDto outputDto){
    Optional<Output> optionalOutput = outputRepository.findById(id);
    if (!optionalOutput.isPresent())
        return new Result("input id not founded",false);
    Output output = optionalOutput.get();
    output.setCode(outputDto.getCode());
    output.setFactureNumber(outputDto.getFactureNumber());
    output.setDate(outputDto.getDate());
    Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
    if (!optionalCurrency.isPresent())
        return new Result("currency id not founded",false);
    Currency currency = optionalCurrency.get();
    output.setCurrency(currency);
    Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(outputDto.getWearHouseId());
    if (!optionalWearHouse.isPresent())
        return new Result("wearHouse id not founded",false);
    WearHouse wearHouse = optionalWearHouse.get();
    output.setWearHouse(wearHouse);
    Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
    if (!optionalCurrency.isPresent())
        return new Result("client Id not founded",false);
    Client client = optionalClient.get();
    output.setClient(client);
    outputRepository.save(output);
    return new Result("Input added",true);
}
public Result deleteOutput(@PathVariable Integer id){
    Optional<Output> outputOptional = outputRepository.findById(id);
    if (outputOptional.isPresent())
        return new Result("input id not founded",false);
    Output output = outputOptional.get();
    outputRepository.delete(output);
    return new Result("input deleted",true);
}
}

