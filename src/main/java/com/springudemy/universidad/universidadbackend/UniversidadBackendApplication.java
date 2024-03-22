package com.springudemy.universidad.universidadbackend;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springudemy.universidad.universidadbackend.repositorios")
@ComponentScan(basePackages = "com.springudemy.universidad.universidadbackend")
public class UniversidadBackendApplication {

	public static void main(String[] args) {
		String[] beanDefinitionNames = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
		/*for (String str : beanDefinitionNames){
			System.out.println(str);
		}*/
	}

}
