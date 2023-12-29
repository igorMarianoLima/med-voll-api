package med.voll.api.dtos.endereco;

public record CadastroEnderecoDTO(
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String uf,
    String complemento,
    String numero
) {
}
