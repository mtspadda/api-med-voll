package med.voll.api.domain.appointment;


import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.medic.Medic;
import med.voll.api.domain.patient.Patient;

import java.time.LocalDateTime;

@Table(name = "appointment")
@Entity(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medic_id")
    private Medic medic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime dateTime;
}
