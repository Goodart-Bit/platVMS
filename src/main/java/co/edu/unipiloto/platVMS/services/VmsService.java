package co.edu.unipiloto.platVMS.services;


import co.edu.unipiloto.platVMS.entities.Vms;
import co.edu.unipiloto.platVMS.repository.VmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VmsService {

    @Autowired
    VmsRepository vmsRepository;

    public List<Vms> getAllVms(){ return vmsRepository.findAll();}

    public Vms newVms(Vms vms){
        return vmsRepository.insert(vms);
    }

    public void updateVms(Vms vms) throws Exception {
        Vms storedVms = null;
        try{
            storedVms = vmsRepository.findById(vms.getId()).get();
        } catch (IllegalArgumentException e){
            throw new Exception("A null id was given");
        } catch (NoSuchElementException e) {
            throw new Exception("An invalid id was given");
        }
        vmsRepository.deleteById(storedVms.getId());
        vmsRepository.insert(vms);
    }

    public Vms getVmsbyId(String id){
        Optional<Vms> vms = vmsRepository.findById(id);
        return vms.get();
    }

    public void deleteVmsById(String id){
        vmsRepository.deleteById(id);
    }
}
