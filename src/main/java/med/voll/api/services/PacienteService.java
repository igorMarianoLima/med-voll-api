package med.voll.api.services;

import med.voll.api.dtos.paciente.CadastroPacienteDTO;
import med.voll.api.entities.Paciente;
import med.voll.api.interfaces.medico.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public List<Paciente> listarTodos() {
        return this._pacienteRepository.findAll();
    }

    public Page<Paciente> listarTodos(Pageable pagination) {
        return this._pacienteRepository.findAll(pagination);
    }
}
