package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Input;
import realproject.lesson11.entity.Output;
import realproject.lesson11.payload.InputDto;
import realproject.lesson11.payload.OutputDto;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.InputService;
import realproject.lesson11.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;
    @GetMapping("/get")
    public List<Output> getInputList(){
        List<Output> outputList = outputService.getOutputList();
        return outputList;
    }
    @GetMapping("/getById/{id}")
    public Output getInputBYId(@PathVariable Integer id){
        Output output = outputService.getOutputById(id);
        return output;
    }
    @PostMapping("/add")
    public Result addInput(@RequestBody OutputDto outputDto){
        Result result = outputService.addOutput(outputDto);
        return result;
    }
    @PutMapping("/edit/{id}")
    public Result editInput(@PathVariable Integer id,@RequestBody OutputDto outputDto){
        Result result = outputService.editOutput(id, outputDto);
        return result;
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteInput(@PathVariable Integer id){
        Result result = outputService.deleteOutput(id);
        return result;
    }
}
