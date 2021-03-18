package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Input;
import realproject.lesson11.payload.InputDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;
    @GetMapping("/get")
    public List<Input> getInputList(){
        List<Input> inputList = inputService.getInputList();
        return inputList;
    }
    @GetMapping("/getById/{id}")
    public Input getInputBYId(@PathVariable Integer id){
        Input inputById = inputService.getInputById(id);
        return inputById;
    }
    @PostMapping("/add")
    public Result addInput(@RequestBody InputDto inputDto){
        Result result = inputService.addInput(inputDto);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result editInput(@PathVariable Integer id,@RequestBody InputDto inputDto){
        Result result = inputService.editInput(id, inputDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteInput(@PathVariable Integer id){
        Result result = inputService.deleteInput(id);
        return result;
    }
}
