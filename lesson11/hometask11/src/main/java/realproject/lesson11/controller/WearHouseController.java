package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.WearHouse;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.WearHouseService;

import java.util.List;

@RestController
@RequestMapping("/wearhouse")
public class WearHouseController {
@Autowired
    WearHouseService wearHouseService;
@GetMapping("/get")
    public List<WearHouse> getWearHouseList(){
    List<WearHouse> wearHouseList = wearHouseService.getWearHouseList();
    return wearHouseList;
}
@GetMapping("/getByid/{id}")
    public WearHouse getWearHouseById(@PathVariable Integer id){
    WearHouse wearHouseById = wearHouseService.getWearHouseById(id);
    return wearHouseById;
}
@PostMapping("/add")
    public Result addWearhouse(@RequestBody WearHouse wearHouse){
    Result result = wearHouseService.addWearHouse(wearHouse);
    return result;
}
@PutMapping("/edit/{id}")
    public Result editWearhouse(@PathVariable Integer id,@RequestBody WearHouse wearHouse){
    Result result = wearHouseService.editWearHouse(id, wearHouse);
    return result;
}
@DeleteMapping("/delete/{id}")
    public Result deleteWearhouse(@PathVariable Integer id){
    Result result = wearHouseService.deleteWearhouse(id);
    return result;
}
}
