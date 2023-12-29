package med.voll.api.dtos.medico;

import med.voll.api.dtos.CadastroEnderecoDTO;
import med.voll.api.enums.Especialidade;

public record CadastroMedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        CadastroEnderecoDTO cadastroEnderecoDTO
) {
}
