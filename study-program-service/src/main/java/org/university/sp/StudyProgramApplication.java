package org.university.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudyProgramApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyProgramApplication.class, args);
    }
}