package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.paciente.CadastroPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteService _pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(
            @RequestBody
            @Valid
            CadastroPacienteDTO paciente
    ) {
        Paciente pacienteEntity = this._pacienteService.cadastrar(paciente);
        return new ResponseEntity<>(pacienteEntity, HttpStatus.CREATED);
    }
}
