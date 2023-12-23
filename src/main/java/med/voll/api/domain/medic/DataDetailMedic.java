package med.voll.api.domain.medic;

import med.voll.api.domain.adress.Adress;

public record DataDetailMedic(Long id, String name, String email, Speciality speciality, String crm, Adress adress) {

    public DataDetailMedic(Medic medic){
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getSpeciality(), medic.getCrm(), medic.getAdress());
    }
}
