package co.edu.unipiloto.platVMS.services;


import co.edu.unipiloto.platVMS.entities.Funcionario;
import co.edu.unipiloto.platVMS.entities.Report;
import co.edu.unipiloto.platVMS.entities.Via;
import co.edu.unipiloto.platVMS.repository.ReportRepository;
import co.edu.unipiloto.platVMS.util.DateHelper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private MongoTemplate mongoTemplate; //Mongo query helper

    @Autowired
    private JavaMailService mailService;
    private DateHelper dateUtility = new DateHelper();

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Report createReport(Report newReport){
        Object[] reportEntities = authenticReportData(newReport.getIdVia());
        Funcionario responsable = (Funcionario) reportEntities[0];
        Via via = (Via) reportEntities[1];
        mailService.notifyReportMail(responsable.getEmail(),newReport.getFechaInicio(),newReport.getTipoEvento(),
                newReport.getIdCreador(), via.getId(), via.getNombre(), via.getMunicipio());
        return reportRepository.insert(newReport);
    }

    private Object[] authenticReportData(String idVia){
        Query funcionarioQuery = new Query();
        Query viaQuery = new Query();
        ObjectId viaId = new ObjectId(idVia);
        funcionarioQuery.addCriteria(Criteria.where("viasAsignadas._id").is(viaId));
        viaQuery.addCriteria(Criteria.where("_id").is(viaId));
        try {
            Funcionario responsable = mongoTemplate.find(funcionarioQuery, Funcionario.class).get(0);
            Via via =  mongoTemplate.find(viaQuery, Via.class).get(0);
            return new Object[] {responsable, via};
        } catch (NullPointerException err){
            throw new RuntimeException(err);
        }
    }

    public Report updateReport(Report updatedReport){
        String targetId = updatedReport.getId();
        reportRepository.deleteById(targetId);
        return reportRepository.insert(updatedReport);
    }

    public List<Report> getReportsBetweenDates(String fechaInicio,String fechaFin){
        ArrayList<Report> matchReports = new ArrayList<>();
        LocalDate iniBound = dateUtility.toLocalDate(fechaInicio);
        LocalDate endBound = dateUtility.toLocalDate(fechaFin);
        for (Report report: getAllReports()) {
            LocalDate reportIniDate = dateUtility.toLocalDate(report.getFechaInicio());
            if (reportIniDate.isAfter(iniBound) && reportIniDate.isBefore(endBound)){
                matchReports.add(report);
            }
        }
        return matchReports;
    }

    public Report getReportById(String id){
        try {
            return reportRepository.findById(id).get();
        } catch (NullPointerException err){
            throw new RuntimeException(err);
        }
    }

    public String deleteReport(String reportId){
        reportRepository.deleteById(reportId);
        return "El reporte " + reportId + " ha sido eliminado";
    }
}
