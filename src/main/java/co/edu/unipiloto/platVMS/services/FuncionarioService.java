package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.entities.Vms;
import co.edu.unipiloto.platVMS.repository.FuncionarioRepository;
import co.edu.unipiloto.platVMS.repository.VmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarios;

    @Autowired
    private VmsRepository paneles;

    public Funcionario addFuncionario(Funcionario newFuncionario){
        return funcionarios.insert(newFuncionario);
    }

    public ArrayList<Vms> asignarPanel(String idFuncionario, String idPanel) throws Exception {
        Funcionario target = null;
        Vms panel = null;
        try{
            target = funcionarios.findById(idFuncionario).get();
            panel = paneles.findById(idPanel).get();
        } catch (Exception e){
            throw new Exception("Invalid id");
        }
        target.asignarPanel(panel);
        funcionarios.deleteById(idFuncionario);
        funcionarios.insert(target);
        return target.getPanelesAsignados();
    }
}