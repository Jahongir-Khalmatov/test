package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Users;
import realproject.lesson11.entity.WearHouse;
import realproject.lesson11.payload.Result;
import realproject.lesson11.payload.UsersDto;
import realproject.lesson11.repository.UsersRepository;
import realproject.lesson11.repository.WearHouseRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WearHouseRepository wearHouseRepository;

    public List<Users> getUsersSet() {
        List<Users> usersList = usersRepository.findAll();
        return  usersList;
    }

    public Users getUsersById(@PathVariable Integer id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if (!optionalUsers.isPresent())
            return new Users();
        Users users = optionalUsers.get();
        return users;
    }

    public Result addUsers(@PathVariable UsersDto usersDto) {
        boolean exists = usersRepository.existsByPhoneNumber(usersDto.getPhoneNumber());
        if (exists)
            return new Result("This phone number is already exists", false);
        Users users = new Users();
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setPassword(usersDto.getPassword());
        users.setCode(usersDto.getCode());
        users.setActive(usersDto.isActive());
        Set<WearHouse> wearHouseSet = new HashSet<>();
        Set<Integer> integers = usersDto.getWearHousesId();
        for (Integer integer : integers) {
            Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(integer);
            if (!optionalWearHouse.isPresent())
                return null;
            WearHouse wearHouse = optionalWearHouse.get();
            wearHouseSet.add(wearHouse);
        }
        users.setWearHouses(wearHouseSet);
        usersRepository.save(users);
        return new Result("User added", true);
    }

    public Result editUsers(@PathVariable Integer id, @RequestBody UsersDto usersDto) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if (!optionalUsers.isPresent())
            return new Result("users id not founded", false);
        Users users = optionalUsers.get();
        users.setFirstName(users.getLastName());
        users.setLastName(usersDto.getLastName());
        users.setPhoneNumber(usersDto.getPhoneNumber());
        users.setPassword(usersDto.getPassword());
        users.setCode(usersDto.getCode());
        users.setActive(usersDto.isActive());
        Set<WearHouse> wearHouseSet = new HashSet<>();
        Set<Integer> integers = usersDto.getWearHousesId();
        for (Integer integer : integers) {
            Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(integer);
            if (!optionalWearHouse.isPresent())
                return null;
            WearHouse wearHouse = optionalWearHouse.get();
            wearHouseSet.add(wearHouse);
        }
        users.setWearHouses(wearHouseSet);
        usersRepository.save(users);
        return new Result("User is edited", true);
    }
    public Result deleteUsers(@PathVariable Integer id){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if (!optionalUsers.isPresent())
            return new Result("Users id not founded",false);
        Users users = optionalUsers.get();
        usersRepository.delete(users);
        return new Result("user is deleted",true);
    }
}
