package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.adress.Adress;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private Long id;

    private String name;

    private String phoneNumber;

    @Embedded
    private Adress adress;

    private Boolean status;


    public Patient(PatientData data){
        this.name = data.name();
        this.phoneNumber = data.phoneNumber();
        this.adress = new Adress(data.adress());
        this.status = true;
    }

    public void updatePatient(DataUpdatePatient dataUpdatePatient){
        if (dataUpdatePatient.name() != null){
            this.name = dataUpdatePatient.name();
        }
        if (dataUpdatePatient.phoneNumber() != null){
            this.phoneNumber = dataUpdatePatient.phoneNumber();
        }
    }

}
