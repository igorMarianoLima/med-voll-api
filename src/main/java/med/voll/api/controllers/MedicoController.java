package med.voll.api.controllers;

import med.voll.api.dtos.medico.CadastroMedicoDTO;

import med.voll.api.entities.Medico;
import med.voll.api.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoService _medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(
        @RequestBody CadastroMedicoDTO medico
    ) {
        Medico medicoEntity = this._medicoService.cadastrar(medico);

        if (medicoEntity != null) {
            return new ResponseEntity<Medico>(medicoEntity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
