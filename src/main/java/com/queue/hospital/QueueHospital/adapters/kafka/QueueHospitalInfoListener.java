package com.queue.hospital.QueueHospital.adapters.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.queue.hospital.QueueHospital.domain.entity.RedisEntity;
import com.queue.hospital.QueueHospital.domain.repository.RedisRepository;

@Component
public class QueueHospitalInfoListener {

	@Autowired
	private RedisRepository redisRepository;
	
    @KafkaListener(topics = "topic-update-info-queue")
    public void consume(@Payload ConsumerRecord<String, String> payload, Acknowledgment ack){

    	Gson g = new Gson();  
    	RedisEntity entity = g.fromJson(payload.value(), RedisEntity.class);
    	
    	redisRepository.save(entity);
    	
        ack.acknowledge();

    }
}
