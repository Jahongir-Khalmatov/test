package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Supplier;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    public Result addSupplier(@RequestBody Supplier supplier){
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("the mobile phone already registered",false);
supplierRepository.save(supplier);
return new Result("supplier added",true);
    }
    public List<Supplier> getSupplierList(){
        List<Supplier> supplierList = supplierRepository.findAll();
        return supplierList;
    }
    public Supplier getSupplierById(@PathVariable Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Supplier();
        Supplier supplier = optionalSupplier.get();
        return supplier;
    }
    public Result editSupplier(@PathVariable Integer id,@RequestBody Supplier supplier){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("supplier id not founded",false);
        Supplier supplier1 = optionalSupplier.get();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplier1.setActive(supplier.isActive());
        supplierRepository.save(supplier1);
        return new Result("supplier edited",true);
    }
    public Result deleteSupplier(@PathVariable Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("supplier id not founded",false);
        Supplier supplier = optionalSupplier.get();
        supplierRepository.delete(supplier);
        return new Result("supplier deleted",true);
    }
}
