package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Users;
import realproject.lesson11.payload.Result;
import realproject.lesson11.payload.UsersDto;
import realproject.lesson11.service.UsersService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    @GetMapping("/getById/{id}")
    public Users getUsersById(@PathVariable Integer id){
        Users users = usersService.getUsersById(id);
        return users;
    }
    @GetMapping("/usersList")
    public List<Users> getUsersSet(){
        List<Users> usersList = usersService.getUsersSet();
        return usersList;
    }
    @PostMapping("/add")
    public Result addUsers(@RequestBody UsersDto usersDto){
        Result result = usersService.addUsers(usersDto);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result editUsers(@PathVariable Integer id,@RequestBody UsersDto usersDto){
        Result result = usersService.editUsers(id, usersDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteUSers(@PathVariable Integer id){
        Result result = usersService.deleteUsers(id);
        return result;
    }

}
