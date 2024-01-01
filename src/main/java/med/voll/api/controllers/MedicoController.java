package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.medico.CadastroMedicoDTO;

import med.voll.api.dtos.medico.ListarMedicoDTO;
import med.voll.api.entities.Medico;
import med.voll.api.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoService _medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> cadastrar(
        @RequestBody
        @Valid
        CadastroMedicoDTO medico
    ) {
        Medico medicoEntity = this._medicoService.cadastrar(medico);

        return new ResponseEntity<Medico>(medicoEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ListarMedicoDTO>> listarTodos() {
        List<ListarMedicoDTO> listaMedicos = this._medicoService.listarTodos().stream().map(ListarMedicoDTO::new).toList();

        return new ResponseEntity<>(listaMedicos, HttpStatus.OK);
    }
}
