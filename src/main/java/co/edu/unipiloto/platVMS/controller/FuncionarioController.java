package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value="/asignarPanel")
    public ArrayList<Document> asignarPanel(String idFuncionario, String idPanel){
        return funcionarioService.asignarPanel(idFuncionario, idPanel);
    }
}
