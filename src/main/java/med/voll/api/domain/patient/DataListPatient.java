package med.voll.api.domain.patient;

public record DataListPatient(String name, String phoneNumber) {

    public DataListPatient(Patient patient) {
        this(patient.getName(), patient.getPhoneNumber());
    }
}