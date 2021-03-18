package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Currency;
import realproject.lesson11.entity.Measurement;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.CurrencyRepository;
import realproject.lesson11.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
public Result addCurrencyService(@RequestBody Currency currency){
    boolean exists = currencyRepository.existsByName(currency.getName());
    if (exists) {
        return new Result("bunday pul birligi mavjud", false);
    }
        currencyRepository.save(currency);
return new Result("pul birligi qo'shildi",true);
}
public List<Currency> getCurrency(){
    List<Currency> list = currencyRepository.findAll();
    return list;
}
public Currency getCurrencyById(@PathVariable Integer id){
    Optional<Currency> optionalCurrency = currencyRepository.findById(id);
    if (!optionalCurrency.isPresent())
        return new Currency();
    Currency currency = optionalCurrency.get();
    return currency;
}
public Result editCurrency(@PathVariable Integer id,@RequestBody Currency currency){
    Optional<Currency> optionalCurrency = currencyRepository.findById(id);
    if (!optionalCurrency.isPresent())
        return new Result("currency id not founded",false);
    Currency currency1 = optionalCurrency.get();
    currency1.setName(currency.getName());
    currency1.setActive(currency.isActive());
    currencyRepository.save(currency);
return new Result("Currency is changed",true);
}
public Result deleteCurrency(@PathVariable Integer id){
    Optional<Currency> optionalCurrency = currencyRepository.findById(id);
    if (!optionalCurrency.isPresent())
        return new Result("measurement id not founed",false);
    Currency currency = optionalCurrency.get();
    currencyRepository.delete(currency);
    return new Result("measurement deleted",true);
}
}
