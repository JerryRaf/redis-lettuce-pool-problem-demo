package com.example.redis.redisdemo;

import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RedisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}

	@RestController
	public static class RedisController {

		@Autowired
		private RedisConnectionFactory redisConnectionFactory;

		@Autowired
		private StringRedisTemplate stringRedisTemplate;


		@GetMapping(value = "/getRedisCluster")
		public String getRedisCluster() {
//			byte[] bytes = redisConnectionFactory.getClusterConnection().stringCommands()
//					.get("key".getBytes());
//			if (bytes != null) {
//				String value = new String(bytes, StandardCharsets.UTF_8);

				stringRedisTemplate.opsForValue().set("stringKey", "stringValue");
				String stringValue = stringRedisTemplate.opsForValue().get("stringKey");
				return stringValue;
//      return "ok";
//			} else {
//				return "error";
//			}
		}
	}
}
