package com.ruleta.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.ruleta.entities.Apuesta;
import com.ruleta.entities.Ruleta;
//import redis.embedded.RedisServer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguracion {

	
	@Bean
    public LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
        return new LettuceConnectionFactory(redisProperties.getRedisHost(), redisProperties.getRedisPort());
    }
	

	@Bean
	public RedisTemplate<String, Ruleta> redisTemplate_Ruleta(LettuceConnectionFactory connectionFactory) {
		final RedisTemplate<String, Ruleta> redisTemplate = new RedisTemplate<>();
		redisTemplate .setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
	
	
	@Bean
	public RedisTemplate<String, Apuesta> redisTemplate_Apuesta(LettuceConnectionFactory connectionFactory) {
		final RedisTemplate<String, Apuesta> redisTemplate = new RedisTemplate<>();
		redisTemplate .setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
	

}
