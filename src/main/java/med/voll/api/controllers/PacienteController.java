package med.voll.api.controllers;

import med.voll.api.dtos.paciente.CadastroPacienteDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @PostMapping
    public String cadastrar(
            @RequestBody CadastroPacienteDTO paciente
    ) {
        System.out.println(paciente);
        return String.format("Olá paciente %s! Seja bem vindo", paciente.nome());
    }
}
