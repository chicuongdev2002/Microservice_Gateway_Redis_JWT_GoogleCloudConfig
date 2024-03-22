package iuh.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class UserApplication implements ApplicationRunner {
	@Autowired
	public RedisTemplate redisTemplate;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		redisTemplate.opsForValue().set("message", "Hello Redis!");
		System.out.println(redisTemplate.opsForValue().get("message"));
	}
}
