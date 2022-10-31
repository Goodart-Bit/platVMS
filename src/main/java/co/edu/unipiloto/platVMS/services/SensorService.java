package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.entities.Sensor;
import co.edu.unipiloto.platVMS.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    public List<Sensor> getAllSensors(){
        return sensorRepository.findAll();
    }

    public void newSensor(Sensor sensor){
        sensorRepository.insert(sensor);
    }

    public void updateSensor(Sensor sensor){
        sensorRepository.deleteById(sensor.getId());
        sensorRepository.insert(sensor);
    }

    public Sensor getSensorbyId(String id){
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return sensor.get();
    }
}
