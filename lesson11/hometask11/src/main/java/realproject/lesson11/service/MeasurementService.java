package realproject.lesson11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import realproject.lesson11.entity.Measurement;
import realproject.lesson11.payload.Result;
import realproject.lesson11.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;
public Result addMeasurementService(@RequestBody Measurement measurement){
    boolean exists = measurementRepository.existsByName(measurement.getName());
    if (exists) {
        return new Result("bunday o'lchov birligi mavjud", false);
    }
        measurementRepository.save(measurement);
return new Result("o'lchov birligi qo'shildi",true);
}
public List<Measurement> getMeasurement(){
    List<Measurement> list = measurementRepository.findAll();
    return list;
}
public Measurement getMeasurementById(@PathVariable Integer id){
    Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
    if (!optionalMeasurement.isPresent())
        return new Measurement();
    Measurement measurement = optionalMeasurement.get();
    return measurement;
}
public Result editMeasurement(@PathVariable Integer id,@RequestBody Measurement measurement){
    Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
    if (!optionalMeasurement.isPresent())
        return new Result("id not founded",false);
    Measurement measurement1 = optionalMeasurement.get();
    measurement1.setName(measurement.getName());
    measurement1.setActive(measurement.isActive());
    measurementRepository.save(measurement1);
return new Result("Measurement is changed",true);
}
public Result deleteMeasurement(@PathVariable Integer id){
    Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
    if (!optionalMeasurement.isPresent())
        return new Result("measurement id not founed",false);
    Measurement measurement = optionalMeasurement.get();
    measurementRepository.delete(measurement);
    return new Result("measurement deleted",true);
}
}
