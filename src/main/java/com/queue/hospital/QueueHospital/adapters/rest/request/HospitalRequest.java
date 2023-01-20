package com.queue.hospital.QueueHospital.adapters.rest.request;

import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class HospitalRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotBlank
    @Size(min = 11, message = "tamanho minimo do campo não foi correspondido")
    @Size(max = 11, message = "tamanho máximo do campo foi excedido")
    @Pattern(regexp = "^[0-9]*$")
    private String telefone;

    public Hospital get(){
        return new Hospital(nome, endereco, telefone);
    }
}
