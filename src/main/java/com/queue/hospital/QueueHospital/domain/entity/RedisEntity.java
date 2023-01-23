package com.queue.hospital.QueueHospital.domain.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RedisHash("RedisEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedisEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String hospital;
	
	private String waiting_time;
	
	public String getHospital() {
		return hospital;
	}

	public String getWaiting_time() {
		return waiting_time;
	}

	public void setWaiting_time(String waiting_time) {
		this.waiting_time = waiting_time;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
}
