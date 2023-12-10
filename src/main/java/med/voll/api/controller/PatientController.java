package med.voll.api.controller;

import med.voll.api.medic.DataListMedic;
import med.voll.api.patient.DataListPatient;
import med.voll.api.patient.Patient;
import med.voll.api.patient.PatientData;
import med.voll.api.patient.PatientRepository;
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
}
