package cachingExample.cacheCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheCrudApplication.class, args);
	}

}
