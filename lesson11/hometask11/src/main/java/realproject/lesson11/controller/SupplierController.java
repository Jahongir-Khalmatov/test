package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Supplier;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @GetMapping("/getSupplierById/{id}")
    public Supplier getSupplierById(@PathVariable Integer id){
        Supplier supplier = supplierService.getSupplierById(id);
        return supplier;
    }
    @GetMapping("/getList")
    public List<Supplier> getSupplierList(){
        List<Supplier> supplierList = supplierService.getSupplierList();
        return supplierList;
    }
    @PostMapping("/add")
    public Result addSupplier(@RequestBody Supplier supplier){
        Result result = supplierService.addSupplier(supplier);
        return result;
    }
    @PutMapping("/edit")
    public Result editSupplier(@PathVariable Integer id,@RequestBody Supplier supplier){
        Result result = supplierService.editSupplier(id, supplier);
        return result;
    }

}
