package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.paciente.CadastroPacienteDTO;
import med.voll.api.dtos.paciente.ListarPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<ListarPacienteDTO>> listarTodos(
        Pageable pagination
    ) {
        Page<ListarPacienteDTO> pacientes = this._pacienteService.listarTodos(pagination).map(
            paciente -> new ListarPacienteDTO(paciente.getNome(), paciente.getEmail(), paciente.getCpf())
        );

        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
}
