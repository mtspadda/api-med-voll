package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medic.DataListMedic;
import med.voll.api.medic.DataUpdateMedic;
import med.voll.api.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void save(@RequestBody PatientData data) {
        repository.save(new Patient(data));

    }

    @GetMapping
    public Page<DataListPatient> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DataListPatient::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePatient(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdatePatient dataUpdatePatient){
        var medic = repository.getReferenceById(dataUpdatePatient.id());
        medic.updatePatient(dataUpdatePatient);
    }
}
