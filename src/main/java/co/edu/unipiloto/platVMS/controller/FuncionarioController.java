package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.entities.Vms;
import co.edu.unipiloto.platVMS.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "funcionario/")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping (value = "/add")
    public Funcionario addFuncionario(Funcionario funcionario){
        return funcionarioService.addFuncionario(funcionario);
    }

    @PutMapping (value="/asignarPanel/{idFuncionario}&{idPanel}")
    public ArrayList<Vms> asignarPanel(@PathVariable("idFuncionario") String idFuncionario, @PathVariable("idPanel") String idPanel) throws Exception {
        return funcionarioService.asignarPanel(idFuncionario, idPanel);
    }
}
