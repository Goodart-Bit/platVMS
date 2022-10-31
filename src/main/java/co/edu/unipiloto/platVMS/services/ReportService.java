package co.edu.unipiloto.platVMS.services;


import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Report createReport(Report newReport){
        return reportRepository.insert(newReport);
    }

    public Report updateReport(Report newReport){
        Optional<Report> optionalReport = reportRepository.findById(newReport.getId());
        if(!optionalReport.isPresent()){
            return null;
        }
        Report storedReport = optionalReport.get();
        storedReport.setId(newReport.getId());
        storedReport.setFecha(newReport.getFecha());
        storedReport.setTipoEvento(newReport.getTipoEvento());
        storedReport.setIdCreador(newReport.getIdCreador());
        return reportRepository.insert(storedReport);
    }

    public String deleteReport(String reportId){
        reportRepository.deleteById(reportId);
        return "El reporte " + reportId + " ha sido eliminado";
    }
}
