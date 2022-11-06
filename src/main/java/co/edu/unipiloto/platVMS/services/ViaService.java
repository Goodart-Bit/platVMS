package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.entities.Via;
import co.edu.unipiloto.platVMS.repository.ViaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaService {

    @Autowired
    ViaRepository vias;

    public Via addVia(Via nuevaVia){
        return vias.insert(nuevaVia);
    }

    public String removerVia(String idVia) throws Exception {
        vias.deleteById( getViaPorId(idVia).getId() );
        return idVia;
    }

    public Via getViaPorId(String id) throws Exception {
        try{
            return vias.findById(id).get();
        } catch (NullPointerException err){
            System.out.println(err);
            throw new Exception("Id invalido");
        }
    }

}
