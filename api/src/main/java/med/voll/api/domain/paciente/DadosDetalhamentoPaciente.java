package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;

public record DadosDetalhamentoPaciente(Long id, String nome, Endereco endereco, String telefone) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEndereco(), paciente.getTelefone());
    }
}
