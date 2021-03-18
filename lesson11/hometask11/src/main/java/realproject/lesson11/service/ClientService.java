package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Client;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
@Autowired
    ClientRepository clientRepository;
public List<Client> getList(){
    return clientRepository.findAll();
}
public Client getClientById(@PathVariable Integer id){
    Optional<Client> optionalClient = clientRepository.findById(id);
    if (!optionalClient.isPresent())
        return new Client();
    Client client = optionalClient.get();
    return client;
}
public Result addClient(@RequestBody Client client){
    boolean exists = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
    if (exists)
        return new Result("This phone number already exists",false);
    Client client1 = new Client();
    client1.setPhoneNumber(client.getPhoneNumber());
    client1.setName(client.getName());
    client1.setActive(client.isActive());
    clientRepository.save(client1);
    return new Result("Client added",true);
}
public Result editClient(@PathVariable Integer id,@RequestBody Client client){
    Optional<Client> optionalClient = clientRepository.findById(id);
    if (!optionalClient.isPresent())
        return new Result("client id not founded",false);
    boolean exists = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
    if (exists)
        return new Result("This phone number already exists",false);
    Client client1 = new Client();
    client1.setPhoneNumber(client.getPhoneNumber());
    client1.setName(client.getName());
    client1.setActive(client.isActive());
    clientRepository.save(client1);
    return new Result("Client added",true);
}
public Result deleteClient(@PathVariable Integer id){
    Optional<Client> optionalClient = clientRepository.findById(id);
    if (!optionalClient.isPresent())
        return new Result("Client id not founded",false);
    Client client = optionalClient.get();
    clientRepository.delete(client);
    return new Result("Client Deleted",true);
}


}

