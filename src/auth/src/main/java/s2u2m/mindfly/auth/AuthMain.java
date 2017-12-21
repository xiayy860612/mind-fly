package s2u2m.mindfly.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *
 * @author xiayy860612
 */
@SpringBootApplication
public class AuthMain extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AuthMain.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AuthMain.class);
	}


}
