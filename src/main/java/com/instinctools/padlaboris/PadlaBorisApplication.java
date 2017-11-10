package com.instinctools.padlaboris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.instinctools.padlaboris.repository")
@SuppressWarnings("PMD")
public class PadlaBorisApplication {

    public static void main(final String... args) {
        SpringApplication.run(PadlaBorisApplication.class, args);
    }
}
