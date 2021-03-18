package appapilesson1.hometask1.controller;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.entity.Department;
import appapilesson1.hometask1.payload.AddressDto;
import appapilesson1.hometask1.payload.DepartmentDto;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.service.AddressService;
import appapilesson1.hometask1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/get")
public ResponseEntity<?> getList(){
        List<Department> list = departmentService.getList();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/getById/{id}")
public ResponseEntity<?> getById(@PathVariable Integer id){
        Department byId = departmentService.getById(id);
        return ResponseEntity.ok(byId);
}
    @PostMapping("/add")
public HttpEntity<Response> add(@Valid @RequestBody DepartmentDto departmentDto){
        Response response = departmentService.add(departmentDto);
        if (response.isSuccess()){
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
}
@PutMapping("/edit/{id}")
public ResponseEntity<Response> edit(@Valid @RequestBody DepartmentDto departmentDto,@PathVariable Integer id){
        Response edit = departmentService.edit(id, departmentDto);
        if (edit.isSuccess()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(edit);

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(edit);
}
    @DeleteMapping("/delete/{id}")

public ResponseEntity<Response> delete(@PathVariable Integer id){
        Response delete = departmentService.delete(id);
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
