package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           Student mahamat = new Student(
                    1l,
                    "Mahamat",
                    "Ahamt",
                    "mahamtahamt@gemail.com"

            );
           Student saleh = new Student(
                   "saleh",
                   "Abdelkerim",
                   "salehabdelkerim@gmeil.com"
           );
           studentRepository.saveAll(
                   List.of(mahamat,saleh)
           );
        };
    }
}
