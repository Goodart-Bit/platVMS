package co.edu.unipiloto.platVMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JavaMailService {

    @Autowired
    private JavaMailSender sender;

    public JavaMailService(){
    }

    public void sendMail(String receptor, String asunto, String cuerpo){
        SimpleMailMessage correo = new SimpleMailMessage();
        correo.setFrom(receptor);
        correo.setTo(receptor);
        correo.setSubject(asunto);
        correo.setText(cuerpo);
        sender.send(correo);
    }

    public void notifyReportMail(String receptor, String date, String eventType, String idCreador, String idVia, String nombreVia, String municipioVia){
        String asunto = "Reporte en via asignada";
        String body = "Un evento relacionado con \"" + eventType + "\", ha sido reportado en la via " + nombreVia +
                " en el municipio de " + municipioVia + " con id #" + idVia + ".\nEl reporte fue expedido por el usuario con id " + idCreador +
                "\nFecha de reporte: " + date;
        sendMail(receptor, asunto, body);
    }
}
