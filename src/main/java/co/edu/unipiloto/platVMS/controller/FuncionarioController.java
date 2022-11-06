package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.entities.Via;
import co.edu.unipiloto.platVMS.services.FuncionarioService;
import co.edu.unipiloto.platVMS.services.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "funcionario/")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ViaService viasService;

    @PostMapping (value = "/add")
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario){
        Funcionario test = funcionario;
        return funcionarioService.addFuncionario(funcionario);
    }

    @PutMapping (value = "/update")
    public ResponseEntity updateFuncionario(@RequestBody Funcionario actualizado) throws Exception {
        return ResponseEntity.ok(funcionarioService.updateFuncionario(actualizado));
    }

    @DeleteMapping (value = "/delete={id}")
    public ResponseEntity deleteFuncionario(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(funcionarioService.deleteFuncionario(id));
    }
    @PutMapping (value = "/{idFuncionario}/new-asign-panel={viaId}")
    public ResponseEntity asignarVia(@PathVariable("idFuncionario") String idFuncionario, @PathVariable("viaId") String idVia) throws Exception {
        Via viaLocal = viasService.getViaPorId(idVia);
        return ResponseEntity.ok(funcionarioService.asignarVia(idFuncionario, viaLocal));
    }
    @PutMapping(value = "/{idFuncionario}/removed-panel={idPanel}")
    public ResponseEntity deleteVia(@PathVariable("idFuncionario") String idFuncionario, @PathVariable("idVia") String idVia){
        try {
            viasService.removerVia(idVia);
            return ResponseEntity.ok(funcionarioService.quitarVia(idFuncionario,idVia));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
