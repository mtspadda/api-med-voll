package med.voll.api.patient;

public record DataListPatient(String name, String phoneNumber) {

    public DataListPatient(Patient patient) {
        this(patient.getName(), patient.getPhoneNumber());
    }
}