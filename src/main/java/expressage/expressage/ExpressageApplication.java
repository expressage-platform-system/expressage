package expressage.expressage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ExpressageApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpressageApplication.class, args);
	}
}
