package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.services.AgenteService;
import co.edu.unipiloto.platVMS.services.FuncionarioService;
import co.edu.unipiloto.platVMS.services.ReportService;
import co.edu.unipiloto.platVMS.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/get")
    public List<Report> getAllReports(){
        return reportService.getAllReports();
    }

    @PostMapping(value = "/newReport")
    public ResponseEntity add(@RequestBody Report report){
        return ResponseEntity.ok(reportService.createReport(report));
    }

    @GetMapping(value="/from{fechaInicio}to{fechaFinal}")
    public ResponseEntity getReportsBetweenDates(@PathVariable(value="fechaInicio") String fechaInicio,@PathVariable(value="fechaFinal") String fechaFin){
        return ResponseEntity.ok(reportService.getReportsBetweenDates(fechaInicio, fechaFin));
    }

    @PutMapping(value = "/editReport")
    public Report updateMessage(Report report){
        return reportService.updateReport(report);
    }

    @DeleteMapping(value="/delReport/{id}")
    public String deleteMessageById(@PathVariable String id){
        return reportService.deleteReport(id);
    }


}
