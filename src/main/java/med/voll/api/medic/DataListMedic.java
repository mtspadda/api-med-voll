package med.voll.api.medic;

public record DataListMedic(String name, String email, Specialty specialty, String crm) {

    public DataListMedic(Medic medic){
        this(medic.getName(), medic.getEmail(), medic.getSpecialty(), medic.getCrm());
    }
}
