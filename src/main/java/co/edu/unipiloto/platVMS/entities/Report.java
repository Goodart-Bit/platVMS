package co.edu.unipiloto.platVMS.entities;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    private String id;
    private String fecha;
    private String idCreador;

    private String tipoEvento;


    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public Report(String fecha, String idCreador, String tipoEvento) {
        this.fecha = fecha;
        this.idCreador = idCreador;
        this.tipoEvento = tipoEvento;
    }
}
