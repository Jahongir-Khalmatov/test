package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Client;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/getList")
    public List<Client> getList(){
        List<Client> clientList = clientService.getList();
        return clientList;
    }
    @GetMapping("/getById/{id}")
    public Client getClientById(@PathVariable Integer id){
        Client clientById = clientService.getClientById(id);
        return clientById;
    }
    @PostMapping("/add")
    public Result addClient(@RequestBody Client client){
        Result result = clientService.addClient(client);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result editClient(@PathVariable Integer id,@RequestBody Client client){
        Result result = clientService.editClient(id, client);
        return result;
    }
    @DeleteMapping("delete/{id}")
    public Result deleteClient(@PathVariable Integer id){
        Result result = clientService.deleteClient(id);
        return result;
    }
}
