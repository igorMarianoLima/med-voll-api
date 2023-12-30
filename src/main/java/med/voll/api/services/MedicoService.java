package med.voll.api.services;

import med.voll.api.dtos.medico.CadastroMedicoDTO;
import med.voll.api.entities.Medico;
import med.voll.api.interfaces.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository _medicoRepository;

    public Medico cadastrar(CadastroMedicoDTO medico) {
        Medico medicoEntity = new Medico(medico);

        try {
            medicoEntity = this._medicoRepository.save(medicoEntity);
            return medicoEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Houve um erro ao cadastrar o médico"
            );
        }
    }
}
