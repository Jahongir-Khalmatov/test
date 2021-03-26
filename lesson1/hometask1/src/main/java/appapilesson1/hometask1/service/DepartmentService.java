package appapilesson1.hometask1.service;

import appapilesson1.hometask1.entity.Company;
import appapilesson1.hometask1.entity.Department;
import appapilesson1.hometask1.payload.DepartmentDto;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.repository.CompanyRepository;
import appapilesson1.hometask1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CompanyRepository companyRepository;
    public List<Department> getList(){
        List<Department> list = departmentRepository.findAll();
        return list;
    }
    public Department getById(@PathVariable Integer id){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new Department();
        Department department = optionalDepartment.get();
        return department;
    }
    public Response add(@RequestBody DepartmentDto departmentDto){
        Department department = new Department();
        department.setName(departmentDto.getName());
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (!optionalCompany.isPresent())
            return new Response("company id not founded",false);
        Company company = optionalCompany.get();
        department.setCompany(company);
        return new Response("added",true);
    }
    public Response edit(@PathVariable Integer id,@RequestBody DepartmentDto departmentDto){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new Response("id not founded",false);
        Department department = new Department();
        department.setName(departmentDto.getName());
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (!optionalCompany.isPresent())
            return new Response("company id not founded",false);
        Company company = optionalCompany.get();
        department.setCompany(company);
        return new Response("added",true);
    }
    public Response delete(@PathVariable Integer id){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new Response("id not founded",false);
        Department department = optionalDepartment.get();
        departmentRepository.delete(department);
        return new Response("deleted",true);
    }
}
