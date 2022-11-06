package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Via;
import co.edu.unipiloto.platVMS.services.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "vias/")
public class ViaController {

    @Autowired
    ViaService viaService;

    @PostMapping(value="/add")
    public Via add(@RequestBody Via nuevaVia){
        return viaService.addVia(nuevaVia);
    }

    @DeleteMapping(value="/{idVia}")
    public String remove(@PathVariable String idVia){
        try {
            return viaService.removerVia(idVia);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value="/{idVia}")
    public Via getViaPorId(@PathVariable String id){
        try {
            return viaService.getViaPorId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
