package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medic")
public class MedicController {

    @Autowired
    private MedicRepository repository;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid MedicData data) {
        repository.save(new Medic(data));

    }

    @GetMapping
    public Page<DataListMedic> listing(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByStatusTrue(pageable).map(DataListMedic::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateMedic dataUpdateMedic){
        var medic = repository.getReferenceById(dataUpdateMedic.id());
        medic.updateInfo(dataUpdateMedic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedico(@PathVariable Long id){
        repository.deleteById(id);
    }

    @DeleteMapping("/inativa/{id}")
    @Transactional
    public void inativateMedic(@PathVariable Long id){
        var medic = repository.getReferenceById(id);
        medic.delete();
    }
}
