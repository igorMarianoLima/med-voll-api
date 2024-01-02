package med.voll.api.dtos.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dtos.endereco.CadastroEnderecoDTO;

public record AtualizarMedicoDTO(
    @NotNull
    Long id,
    String nome,
    String telefone,
    CadastroEnderecoDTO endereco
) {
}
