package med.voll.api.dtos.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dtos.endereco.CadastroEnderecoDTO;
import med.voll.api.enums.Especialidade;
import org.hibernate.validator.constraints.Length;

public record CadastroMedicoDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        @Length(
            min = 4,
            max = 6
        )
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        CadastroEnderecoDTO endereco
) {
}
