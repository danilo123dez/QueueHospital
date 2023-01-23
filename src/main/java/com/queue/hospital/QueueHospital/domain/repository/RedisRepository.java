package com.queue.hospital.QueueHospital.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.queue.hospital.QueueHospital.domain.entity.RedisEntity;

@Repository
public interface RedisRepository extends JpaRepository <RedisEntity, String> {

}
