package co.edu.unipiloto.platVMS.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Report {
    @Id
    private String id;
    private String fechaInicio;
    private String fechaFin;
    private String idCreador;

    private String idVia;

    private double[] coordenadas;
    private String tipoEvento;
    private String tipoCierre;

    public Report(String fechaInicio, String fechaFin, String idCreador, String idVia, double[] coordenadas, String tipoEvento, String tipoCierre) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idCreador = idCreador;
        this.idVia = idVia;
        this.coordenadas = coordenadas;
        this.tipoEvento = tipoEvento;
        this.tipoCierre = tipoCierre;
    }

    public String getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(String idCreador) {
        this.idCreador = idCreador;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public double[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(double[] coordenadas) {
        this.coordenadas = coordenadas;
    }
}
