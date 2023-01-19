package com.queue.hospital.QueueHospital.adapters.rest.request;

import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class HospitalRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;

    public Hospital get(){
        return new Hospital(nome, endereco, telefone);
    }
}
