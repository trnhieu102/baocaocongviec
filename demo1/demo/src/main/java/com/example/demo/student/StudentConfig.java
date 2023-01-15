package com.example.demo.student;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

//    @Bean
//    CommandLineRunner initDatabase(StudentRepository repository){
//
////        return args -> {
////            Student hieu = new Student(
////                    1L,
////                    "Tran Trung Hieu",
////                    LocalDate.of(2001, FEBRUARY, 10),
////                    "nam",
////                    19020077
////            );
////
////            Student uyen = new Student(
////                    2L,
////                    "Mai Uyen",
////                    LocalDate.of(2003, AUGUST, 19),
////                    "nu",
////                    21020573
////            );
////
////            repository.saveAll(
////                    List.of(hieu, uyen)
////            );
////        };
//    }

//    @Bean
//    public FormattingConversionService mvcConversionService() {
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
//
//        DateTimeFormatterRegistrar dateTimeRegistrar = new DateTimeFormatterRegistrar();
//        dateTimeRegistrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        dateTimeRegistrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
//        dateTimeRegistrar.registerFormatters(conversionService);
//
//        DateFormatterRegistrar dateRegistrar = new DateFormatterRegistrar();
//        dateRegistrar.setFormatter(new DateFormatter("dd.MM.yyyy"));
//        dateRegistrar.registerFormatters(conversionService);
//
//        return conversionService;
//    }
}

