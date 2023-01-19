package com.queue.hospital.QueueHospital.adapters.rest.dto;

import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HospitalDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    public HospitalDTO(Hospital hospital){
        this.id = hospital.getId();
        this.nome = hospital.getNome();
        this.endereco = hospital.getEndereco();
        this.telefone = hospital.getTelefone();
    }

    public static List<HospitalDTO> convert(List<Hospital> hospitais){
        return hospitais.stream().map(HospitalDTO::new).collect(Collectors.toList());
    }
}
