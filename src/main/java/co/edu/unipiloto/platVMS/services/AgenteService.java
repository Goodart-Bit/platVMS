package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.repository.AgenteVialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService {

    @Autowired
    AgenteVialRepository agentes;
}
