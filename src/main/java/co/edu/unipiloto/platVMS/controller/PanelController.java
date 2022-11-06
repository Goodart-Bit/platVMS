package co.edu.unipiloto.platVMS.controller;



import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.entities.Vms;
import co.edu.unipiloto.platVMS.services.VmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/panel")
public class PanelController {


    @Autowired
    VmsService vmsService;

    @GetMapping(value = "/healthCheck")
    public ResponseEntity checkHealth(){
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAll(){ return ResponseEntity.ok(vmsService.getAllVms()); }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vms addPanel(@RequestBody Vms vms){
        return vmsService.newVms(vms);
    }

    @PutMapping(value =  "/update")
    public ResponseEntity updatePanelvms(@RequestBody Vms vms) throws Exception {
        vmsService.updateVms(vms);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value =  "/getVmsbyId/{id}")
    public ResponseEntity getVmsById(@PathVariable String id){
        return ResponseEntity.ok(vmsService.getVmsbyId(id));
    }

    @GetMapping (value = "/vms_near_report={radiusKms}")
    public ResponseEntity vmsNearEvent(@RequestBody Report report, @PathVariable double radiusKms){
        return ResponseEntity.ok(vmsService.getVmsFromReportRadius(report,radiusKms));
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteVms(@PathVariable String id){
        vmsService.deleteVmsById(id);
    }

}
