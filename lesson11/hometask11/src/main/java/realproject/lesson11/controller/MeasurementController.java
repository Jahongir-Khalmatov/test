package realproject.lesson11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import realproject.lesson11.entity.Measurement;
import realproject.lesson11.payload.Result;
import realproject.lesson11.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;
@PostMapping("/add")
    public Result addMeasurement(@RequestBody Measurement measurement){
    Result result = measurementService.addMeasurementService(measurement);
    return result;
}
@GetMapping("/get")
    public List<Measurement> getMeasurement(){
    List<Measurement> measurement = measurementService.getMeasurement();
    return measurement;
}
@GetMapping("/getById/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id){
    Measurement measurementById = measurementService.getMeasurementById(id);
    return measurementById;
}
@PutMapping("/edit/{id}")
    public Result editMeasurement(@PathVariable Integer id,@RequestBody Measurement measurement){
    Result result = measurementService.editMeasurement(id, measurement);
    return result;
}
@DeleteMapping("/delete/{id}")
public Result deleteMeasurement(@PathVariable Integer id){
    Result result = measurementService.deleteMeasurement(id);
    return result;
}
}
