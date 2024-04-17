package edu.poli.citas.citasMedicas;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CitasMedicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

	@Bean
	DataSource getDataSource() {
		return DataSourceBuilder.create().driverClassName("org.postgresql.Driver")
				.url("jdbc:postgresql://192.168.0.23:5432/citas_medicas").username("postgres").password("postgres").build();
	}

}
