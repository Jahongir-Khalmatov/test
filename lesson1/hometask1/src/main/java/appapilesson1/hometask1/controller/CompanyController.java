package appapilesson1.hometask1.controller;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.entity.Company;
import appapilesson1.hometask1.payload.AddressDto;
import appapilesson1.hometask1.payload.CompanyDto;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.service.AddressService;
import appapilesson1.hometask1.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @GetMapping("/get")
public ResponseEntity<?> getList(){
        return ResponseEntity.ok(getList());
    }
    @GetMapping("/getById/{id}")


public ResponseEntity<?> getById(@PathVariable Integer id){
        Company byId = companyService.getById(id);
        return ResponseEntity.ok(byId);
}
    @PostMapping("/add")

public HttpEntity<Response> add(@Valid @RequestBody CompanyDto companyDto){
        Response response = companyService.add(companyDto);
        if (response.isSuccess()){
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
}
@PutMapping("/edit/{id}")
public ResponseEntity<Response> edit(@Valid @RequestBody CompanyDto companyDto,@PathVariable Integer id){
        Response edit = companyService.edit(id, companyDto);
        if (edit.isSuccess()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(edit);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(edit);
}
    @DeleteMapping("/delete/{id}")

public ResponseEntity<Response> delete(@PathVariable Integer id){
        Response delete = companyService.delete(id);
        if (delete.isSuccess())
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(delete);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(delete);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
