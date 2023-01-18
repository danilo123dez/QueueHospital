package com.queue.hospital.QueueHospital.adapters.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueHospitalInfoListener {

    @KafkaListener(topics = "topic-event-test")
    public void consume(@Payload String valor, Acknowledgment ack) {

        //TODO Processar registro
        // . . .
        if(!valor.isBlank()){
            System.out.print(valor);
        }

        // Commmit manual, que também será síncrono
        ack.acknowledge();

    }
}
