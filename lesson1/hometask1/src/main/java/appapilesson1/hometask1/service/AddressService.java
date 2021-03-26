package appapilesson1.hometask1.service;

import appapilesson1.hometask1.entity.Address;
import appapilesson1.hometask1.payload.AddressDto;
import appapilesson1.hometask1.payload.Response;
import appapilesson1.hometask1.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public List<Address> getList(){
        List<Address> list = addressRepository.findAll();
        return list;
    }
    public Address getById(@PathVariable Integer id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return null;
        Address address = optionalAddress.get();
        return address;
    }
    public Response addAddress( AddressDto addressDto){
        boolean exists = addressRepository.existsByStreetAndHomeNumber(addressDto.getStreet(), addressDto.getHomeNumber());
        if (!exists) {
            Address address = new Address();
            address.setHomeNumber(addressDto.getHomeNumber());
            address.setStreet(addressDto.getStreet());
            addressRepository.save(address);
            return new Response("added", true);
        }
        return new Response("not added",false);
    }
    public Response edit(@PathVariable Integer id,@RequestBody AddressDto addressDto){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new Response("id not founded",false);
        Address address = optionalAddress.get();
        address.setStreet(addressDto.getStreet());
        address.setHomeNumber(addressDto.getHomeNumber());
        addressRepository.save(address);
        return new Response("edited",true);
    }
    public Response delete(@PathVariable Integer id){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new Response("id not founded",false);
        Address address = optionalAddress.get();
    addressRepository.delete(address);
    return new Response("deleted",true);
    }
}
