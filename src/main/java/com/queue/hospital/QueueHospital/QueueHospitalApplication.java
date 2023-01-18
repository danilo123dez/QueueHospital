package com.queue.hospital.QueueHospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class QueueHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueHospitalApplication.class, args);
	}

}
