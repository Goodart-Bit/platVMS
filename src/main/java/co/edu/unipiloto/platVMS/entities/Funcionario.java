package co.edu.unipiloto.platVMS.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Data
@Document
public class Funcionario {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private ArrayList<Via> viasAsignadas = new ArrayList<>();

    public Funcionario(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Via> getViasAsignadas(){
        return viasAsignadas;
    }
    public void asignarVia(Via via){
        viasAsignadas.add(via);
    }

    public void removerVia(String vmsId) {
        for (int idx = 0; idx < viasAsignadas.size(); idx++){
            if (viasAsignadas.get(idx).getId().equals(vmsId)){
                viasAsignadas.remove(idx);
            }
        }
    }
}