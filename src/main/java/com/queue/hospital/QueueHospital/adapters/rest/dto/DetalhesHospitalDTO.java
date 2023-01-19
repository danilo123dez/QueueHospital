package com.queue.hospital.QueueHospital.adapters.rest.dto;

import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetalhesHospitalDTO {

    private String nome;
    private String endereco;
    private String telefone;

    public DetalhesHospitalDTO(Hospital hospital){
        this.nome = hospital.getNome();
        this.endereco = hospital.getEndereco();
        this.telefone = hospital.getTelefone();
    }
}
