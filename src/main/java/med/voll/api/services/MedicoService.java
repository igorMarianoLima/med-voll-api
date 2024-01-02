package med.voll.api.services;

import med.voll.api.dtos.medico.AtualizarMedicoDTO;
import med.voll.api.dtos.medico.CadastroMedicoDTO;
import med.voll.api.entities.Medico;
import med.voll.api.interfaces.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public Page<Medico> listarTodos(Pageable pageable) {
        return _medicoRepository.findAllByAtivoTrue(pageable);
    }

    public Medico atualizar(AtualizarMedicoDTO dados) {
        Medico medico = _medicoRepository.findById(dados.id())
                        .orElseThrow(
                            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                        );

        medico.atualizarDados(dados);
        return medico;
    }

    public Medico excluir(Long idMedico) {
        Medico medico = _medicoRepository.findById(idMedico)
                        .orElseThrow(
                            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                        );

        medico.excluir();
        return medico;
    }
}
