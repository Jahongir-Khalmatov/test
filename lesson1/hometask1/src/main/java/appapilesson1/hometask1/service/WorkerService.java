package appapilesson1.hometask1.service;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.entity.Department;
import appapilesson1.hometask1.entity.Worker;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.payload.WorkerDto;
import appapilesson1.hometask1.repository.AddressRepository;
import appapilesson1.hometask1.repository.DepartmentRepository;
import appapilesson1.hometask1.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
@Autowired
    WorkerRepository workerRepository;
@Autowired
    AddressRepository addressRepository;
@Autowired
    DepartmentRepository departmentRepository;
public List<Worker> getList(){
    List<Worker> list = workerRepository.findAll();
    return list;
}
public Worker getById(@PathVariable Integer id){
    Optional<Worker> optional = workerRepository.findById(id);
    if (!optional.isPresent())
        return null;
    Worker worker = optional.get();
    return worker;
}
public Response add(@RequestBody WorkerDto workerDto){
    Worker worker=new Worker();
    worker.setName(workerDto.getName());
    worker.setPhoneNumber(workerDto.getPhoneNumber());
    Optional<Department> optionalDepartment = departmentRepository.findById(workerDto.getDepartmentId());
    if (!optionalDepartment.isPresent())
        return new Response("id not founded",false);
    Department department = optionalDepartment.get();
    worker.setDepartment(department);
    Optional<Address> optionalAddress = addressRepository.findById(workerDto.getAddressId());
    if (!optionalAddress.isPresent()){
        Address address = new Address();
        address.setStreet(workerDto.getStreet());
        address.setHomeNumber(workerDto.getHomeNumber());
        addressRepository.save(address);
        worker.setAddress(address);
        return new Response("added",true);
    }
    return new Response("?",false);
}
public Response edit(@PathVariable Integer id,@RequestBody WorkerDto workerDto){
    Optional<Worker> optionalWorker = workerRepository.findById(id);
    if (!optionalWorker.isPresent())
        return new Response("id not founded",false);
    Worker worker = optionalWorker.get();
    Optional<Department> optionalDepartment = departmentRepository.findById(workerDto.getDepartmentId());
    if (!optionalDepartment.isPresent())
        return new Response("id not founded",false);
    Department department = optionalDepartment.get();
    worker.setDepartment(department);
    Optional<Address> optionalAddress = addressRepository.findById(workerDto.getAddressId());
    if (!optionalAddress.isPresent()){
        Address address = new Address();
        address.setStreet(workerDto.getStreet());
        address.setHomeNumber(workerDto.getHomeNumber());
        addressRepository.save(address);
        worker.setAddress(address);
        return new Response("added",true);
    }
    return new Response("?",false);
}
public Response delete(@PathVariable Integer id){
    Optional<Worker> optionalWorker = workerRepository.findById(id);
    if (!optionalWorker.isPresent())
        return new Response("id",false);
    Worker worker = optionalWorker.get();
    workerRepository.delete(worker);
    return new Response("deleted",true);
}
}
