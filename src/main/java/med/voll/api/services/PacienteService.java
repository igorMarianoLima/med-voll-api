package med.voll.api.services;

import med.voll.api.dtos.paciente.CadastroPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.interfaces.medico.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository _pacienteRepository;

    public Paciente cadastrar(CadastroPacienteDTO paciente) {
        Paciente pacienteEntity = new Paciente(paciente);

        try {
            this._pacienteRepository.save(pacienteEntity);
            return pacienteEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Houve um erro ao cadastrar o paciente"
            );
        }
    }
}
