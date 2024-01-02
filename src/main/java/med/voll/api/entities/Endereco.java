package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dtos.endereco.CadastroEnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(CadastroEnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }
    
    public void atualizarDados(CadastroEnderecoDTO endereco) {
        this.logradouro = endereco.logradouro() == null ? this.getLogradouro() : endereco.logradouro();
        this.bairro = endereco.bairro() == null ? this.getBairro() : endereco.bairro();
        this.cep = endereco.cep() == null ? this.getCep() : endereco.cep();
        this.numero = endereco.numero() == null ? this.getNumero() : endereco.numero();
        this.complemento = endereco.complemento() == null ? this.getComplemento() : endereco.complemento();
        this.cidade = endereco.cidade() == null ? this.getCidade() : endereco.cidade();
        this.uf = endereco.uf() == null ? this.getUf() : endereco.uf();
    }
}
