package med.voll.api.dtos.paciente;

import med.voll.api.dtos.endereco.CadastroEnderecoDTO;

public record CadastroPacienteDTO(
    String nome,
    String email,
    String telefone,
    String cpf,
    CadastroEnderecoDTO endereco
) {
}
