package med.voll.api.medic;

public record DataListMedic(Long id, String name, String email, Specialty specialty, String crm) {

    public DataListMedic(Medic medic){
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getSpecialty(), medic.getCrm());
    }
}
