package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.medico.AtualizarMedicoDTO;
import med.voll.api.dtos.medico.CadastroMedicoDTO;

import med.voll.api.dtos.medico.ListarMedicoDTO;
import med.voll.api.entities.Medico;
import med.voll.api.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<ListarMedicoDTO>> listarTodos(
        Pageable paginacao
    ) {
        Page<ListarMedicoDTO> listaMedicos = this._medicoService.listarTodos(paginacao).map(ListarMedicoDTO::new);

        return new ResponseEntity<>(listaMedicos, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Medico> atualizar(
        @RequestBody
        @Valid
        AtualizarMedicoDTO body
    ) {
        Medico medicoAtualizado = this._medicoService.atualizar(body);
        return new ResponseEntity<>(medicoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{idMedico}")
    @Transactional
    public void excluir(
        @PathVariable
        Long idMedico
    ) {
        this._medicoService.excluir(idMedico);
    }
}
