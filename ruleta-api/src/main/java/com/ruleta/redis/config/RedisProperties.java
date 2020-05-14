package com.ruleta.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RedisProperties {
	
    private int redisPort;
    private String redisHost;
 
    public RedisProperties( @Value("${spring.redis.port}") int redisPort, @Value("${spring.redis.host}") String redisHost) {
        this.redisPort = redisPort;
        this.redisHost = redisHost;
    }

 
    // getters
    
	public int getRedisPort() {
		return redisPort;
	}

	
	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

	
	public String getRedisHost() {
		return redisHost;
	}

	
	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

    
}