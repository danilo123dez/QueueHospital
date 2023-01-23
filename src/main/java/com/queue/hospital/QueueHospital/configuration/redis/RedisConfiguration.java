package com.queue.hospital.QueueHospital.configuration.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfiguration {
	
	  @Bean
	  public JedisConnectionFactory redisConnectionFactory() {

	    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);
	    config.setPassword("eYVX7EwVmmxKPCDmwMtyKVge8oLd2t81");
	    return new JedisConnectionFactory(config);
	  }
}