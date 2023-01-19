package com.queue.hospital.QueueHospital.domain.repository;

import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findByNome(String nome);
}
