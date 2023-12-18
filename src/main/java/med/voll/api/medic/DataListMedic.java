package med.voll.api.medic;

public record DataListMedic(Long id, String name, String email, Speciality speciality, String crm) {

    public DataListMedic(Medic medic){
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getSpeciality(), medic.getCrm());
    }
}
