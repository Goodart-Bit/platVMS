package co.edu.unipiloto.platVMS.services;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.entities.Via;
import co.edu.unipiloto.platVMS.repository.FuncionarioRepository;
import co.edu.unipiloto.platVMS.repository.VmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarios;

    @Autowired
    private VmsRepository paneles;

    private Exception invalidIdException = new Exception("Invalid id");

    public Funcionario addFuncionario(Funcionario newFuncionario){
        return funcionarios.insert(newFuncionario);
    }

    public Funcionario getFuncionarioById(String id) throws Exception {
        try {
            return funcionarios.findById(id).get();
        } catch (NullPointerException invalidId){
            throw invalidIdException;
        }
    }

    public Funcionario updateFuncionario(Funcionario overrider) throws Exception {
        String id = overrider.getId();
        Funcionario target = getFuncionarioById(id);
        funcionarios.deleteById(id);
        return funcionarios.insert(overrider);
    }

    public String deleteFuncionario(String id) throws Exception {
        try{
            funcionarios.deleteById(id);
        } catch (Exception error){
            throw invalidIdException;
        }
        return id;
    }

    public ArrayList<Via> asignarVia(String idFuncionario, Via via) throws Exception {
        Funcionario target = getFuncionarioById(idFuncionario);
        target.asignarVia(via);
        funcionarios.deleteById(idFuncionario);
        funcionarios.insert(target);
        return target.getViasAsignadas();
    }

    public ArrayList<Via> quitarVia(String idFuncionario, String idVia) throws Exception {
        Funcionario target = getFuncionarioById(idFuncionario);
        target.removerVia(idVia);
        funcionarios.deleteById(idFuncionario);
        funcionarios.insert(target);
        return target.getViasAsignadas();
    }

}