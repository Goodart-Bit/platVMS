package co.edu.unipiloto.platVMS.controller;

import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/get")
    public List<Report> getAllMessages(){
        return reportService.getAllReports();
    }

    @PostMapping(value = "/createReport")
    public Report addMessage(@RequestBody Report report){
        return reportService.createReport(report);
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
