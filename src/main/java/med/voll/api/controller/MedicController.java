package med.voll.api.controller;

import med.voll.api.medic.MedicData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medic")
public class MedicController {

    @PostMapping
    public void save(@RequestBody MedicData data){

    }
}
