package com.instinctools.padlaboris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"com.instinctools.padlaboris.domain.repository",
        "com.instinctools.padlaboris.application.security.repository"})
@SuppressWarnings("PMD")
public class PadlaBorisApplication {

    public static void main(final String... args) {
        SpringApplication.run(PadlaBorisApplication.class, args);
    }
}
