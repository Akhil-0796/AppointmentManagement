package com.example.appointmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
public class AppointmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementApplication.class, args);
    }

}
