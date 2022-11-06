package co.edu.unipiloto.platVMS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Message {
    @Id
    private String id;
    private String contenido;
    private String id_responsable;
    private String fecha_ini;
    private String fecha_fin;


    public String getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(String resposable) {
        this.id_responsable = resposable;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Message(String contenido, String id_responsable, String fecha_ini, String fecha_fin) {
        this.contenido = contenido;
        this.id_responsable = id_responsable;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }
}