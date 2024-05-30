package com.projects.springboot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepository studentRepository){
        return args -> {
            student charan = new student(
                    "Charan",
                    "charan@gmail.com",
                    LocalDate.of(1995, Month.AUGUST,14)
            );
            student Durga = new student(
                    "Durga",
                    "durga@gmail.com",
                    LocalDate.of(2000, Month.AUGUST,14)
            );
            studentRepository.saveAll(
                    List.of(charan,Durga)
            );
        };
    }
}
