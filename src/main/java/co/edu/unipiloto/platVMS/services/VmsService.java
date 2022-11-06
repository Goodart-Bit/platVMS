package co.edu.unipiloto.platVMS.services;


import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.entities.Vms;
import co.edu.unipiloto.platVMS.repository.VmsRepository;
import co.edu.unipiloto.platVMS.util.DistanceHelper;
import co.edu.unipiloto.platVMS.util.DistanceUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VmsService {

    @Autowired
    VmsRepository vmsRepository;

    DistanceHelper distanceHelper = new DistanceHelper(DistanceUnits.KM);

    public List<Vms> getAllVms(){ return vmsRepository.findAll();}

    public Vms newVms(Vms vms){
        return vmsRepository.insert(vms);
    }

    public void updateVms(Vms updatedVms) {
        if (!vmsRepository.existsById(updatedVms.getId())){
            return;
        }
        vmsRepository.deleteById(updatedVms.getId());
        vmsRepository.insert(updatedVms);
    }

    public Vms getVmsbyId(String id){
        Optional<Vms> vms = vmsRepository.findById(id);
        return vms.get();
    }

    public void deleteVmsById(String id){
        vmsRepository.deleteById(id);
    }

    public List<Vms> getVmsFromReportRadius(Report event, double radiusKms){
        List<Vms> allVms = getAllVms();
        ArrayList<Vms> matchVms = new ArrayList<>();
        double[] puntoEvento = event.getCoordenadas();
        for (Vms vms: allVms) {
            double[] puntoVms = vms.getCoordenadas();
            double distanceKms = distanceHelper.measureDistance(puntoEvento[0],puntoEvento[1],puntoVms[0],puntoVms[1]);
            if (distanceKms <= radiusKms){
                matchVms.add(vms);
            }
        }
        return matchVms;
    }
}
