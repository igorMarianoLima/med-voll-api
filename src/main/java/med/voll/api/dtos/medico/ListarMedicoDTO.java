package med.voll.api.dtos.medico;

import med.voll.api.entities.Medico;
import med.voll.api.enums.Especialidade;

public record ListarMedicoDTO(
    Long id,
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {
    public ListarMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
