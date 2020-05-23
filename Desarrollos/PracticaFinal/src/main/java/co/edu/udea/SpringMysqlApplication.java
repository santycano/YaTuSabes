package co.edu.udea;

import co.edu.udea.dao.InvoiceDao;
import co.edu.udea.model.Invoice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner noteDemo(InvoiceDao noteRepository) {
		return (args) -> {

			ArrayList arrayList = new ArrayList();
			for (Invoice note : noteRepository.findAll()) {
				arrayList.add(note);
			}

			System.out.println("Hola " + arrayList.get((int) (noteRepository.count()-1)));

		};
	}
}
