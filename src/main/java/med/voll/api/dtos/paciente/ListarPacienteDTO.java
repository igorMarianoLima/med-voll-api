package med.voll.api.dtos.paciente;

import med.voll.api.entities.Paciente;

public record ListarPacienteDTO(
    String nome,
    String email,
    String cpf
) {
    public ListarPacienteDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
