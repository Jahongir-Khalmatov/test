package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.WearHouse;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.WearHouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WearHouseService {
@Autowired
    WearHouseRepository wearHouseRepository;
public Result addWearHouse(@RequestBody WearHouse wearHouse){
    boolean existsByName = wearHouseRepository.existsByName(wearHouse.getName());
    if (existsByName)
        return new Result("name is already exists",false);
    WearHouse wearHouse1=new WearHouse();
    wearHouse1.setActive(wearHouse.isActive());
    wearHouse1.setName(wearHouse.getName());
    wearHouseRepository.save(wearHouse1);
    return new Result("werahouse added",true);
}
public List<WearHouse> getWearHouseList(){
    List<WearHouse> houseList = wearHouseRepository.findAll();
    return houseList;
}
public WearHouse getWearHouseById(@PathVariable Integer id){
    Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(id);
    if (!optionalWearHouse.isPresent())
        return new WearHouse();
    WearHouse wearHouse = optionalWearHouse.get();
    return wearHouse;
}
public Result editWearHouse(@PathVariable Integer id,@RequestBody WearHouse wearHouse){
    Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(id);
    if (!optionalWearHouse.isPresent())
        return new Result("wearhouse id not founded",false);
    WearHouse wearHouse1 = optionalWearHouse.get();
    wearHouse1.setName(wearHouse.getName());
    wearHouse1.setActive(wearHouse.isActive());
    wearHouseRepository.save(wearHouse1);
    return new Result("wearhouse edited",true);
}
public Result deleteWearhouse(@PathVariable Integer id){
    Optional<WearHouse> optionalWearHouse = wearHouseRepository.findById(id);
    if (!optionalWearHouse.isPresent())
        return new Result("wearhouse id not founded",false);
    WearHouse wearHouse = optionalWearHouse.get();
    wearHouseRepository.delete(wearHouse);
    return new Result("wearhouse deleted",true);
}
}
