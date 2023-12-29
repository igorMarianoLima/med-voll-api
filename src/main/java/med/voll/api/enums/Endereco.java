package med.voll.api.enums;

public record Endereco(
    String logradouro,
    String bairro,
    String cep,
    String cidade,
    String uf,
    String complemento,
    String numero
) {
}
