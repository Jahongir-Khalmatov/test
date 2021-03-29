package appapilesson1.hometask1.service;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.entity.Company;
import appapilesson1.hometask1.payload.CompanyDto;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.repository.AddressRepository;
import appapilesson1.hometask1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
@Autowired
    CompanyRepository companyRepository;
@Autowired
    AddressRepository addressRepository;
public List<Company> getList(){
    List<Company> list = companyRepository.findAll();
    return list;
}
public Company getById(@PathVariable Integer id){
    Optional<Company> optionalCompany = companyRepository.findById(id);
    if (!optionalCompany.isPresent())
        return null;
    Company company = optionalCompany.get();
    return company;
}
public Response add(@RequestBody CompanyDto companyDto){
    Company company = new Company();
    company.setCorpName(companyDto.getCorpName());
    company.setDirectorName(companyDto.getDirectorName());
    Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddressId());
    if (!optionalAddress.isPresent()){
Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        addressRepository.save(address);
        company.setAddress(address);
        companyRepository.save(company);
        return new Response("added",true);
    }
    return new Response("This address already exists",false);
}
public Response edit(@PathVariable Integer id,@RequestBody CompanyDto companyDto){
    Optional<Company> optionalCompany = companyRepository.findById(id);
    if (!optionalCompany.isPresent())
        return new Response("company id not founded",false);
    Company company = new Company();
    company.setCorpName(companyDto.getCorpName());
    company.setDirectorName(companyDto.getDirectorName());
    Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddressId());
    if (!optionalAddress.isPresent()){
        Address address = optionalAddress.get();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        company.setAddress(address);
        addressRepository.save(address);
        companyRepository.save(company);
        return new Response("added",true);
    }
    return new Response("This address already exists",false);
}
public Response delete(@PathVariable Integer id){
    Optional<Company> optionalCompany = companyRepository.findById(id);
    if (!optionalCompany.isPresent())
        return new Response("company id not founded",false);
    Company company = optionalCompany.get();
    companyRepository.delete(company);
    return new Response("deleted",true);
}
}
