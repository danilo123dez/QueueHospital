package com.queue.hospital.QueueHospital.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false, length = 15)
    private String telefone;

    public Hospital(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void update(Hospital hospital){
        this.nome = hospital.getNome();
        this.endereco = hospital.getEndereco();
        this.telefone = hospital.getTelefone();
    }
}
