package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Currency;
import realproject.lesson11.entity.Supplier;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.CurrencyService;
import realproject.lesson11.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @GetMapping("/getById/{id}")
    public Currency getCurrencuById(@PathVariable Integer id){
        Currency currency = currencyService.getCurrencyById(id);
        return currency;
    }
    @GetMapping("/getList")
    public List<Currency> getCurrencyList(){
        List<Currency> currencyList = currencyService.getCurrency();
        return currencyList;
    }
    @PostMapping("/add")
    public Result addCurrency(@RequestBody Currency currency){
        Result result = currencyService.addCurrencyService(currency);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result editCurrency(@PathVariable Integer id,@RequestBody Currency currency){
        Result result = currencyService.editCurrency(id, currency);
        return result;
    }

}
