package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.medico.AtualizarMedicoDTO;
import med.voll.api.dtos.medico.CadastroMedicoDTO;
import med.voll.api.enums.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(CadastroMedicoDTO medico) {
        this.ativo = true;

        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
    }

    public void atualizarDados(AtualizarMedicoDTO dados) {
        this.nome = dados.nome() == null ? this.nome : dados.nome();
        this.telefone = dados.telefone() == null ? this.telefone : dados.telefone();

        if (dados.endereco() != null) this.endereco.atualizarDados(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}
