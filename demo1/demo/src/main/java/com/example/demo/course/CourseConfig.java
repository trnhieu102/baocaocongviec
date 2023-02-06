package com.example.demo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner initDatabase(CourseRepository repository){
        return args -> {
            Course NMLT = new Course(
                    2L,
                    "Toan roi rac"
            );

            repository.saveAll(List.of(NMLT));
        };
    };
}
