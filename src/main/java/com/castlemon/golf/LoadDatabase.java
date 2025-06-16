package com.castlemon.golf;

import com.castlemon.golf.entity.Round;
import com.castlemon.golf.repository.RoundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoundRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(
                    new Round(LocalDate.of(2023, 8, 12), "Bunclody", "Green", 126, (long) 71.9, 117, 0, (long) 28.4, 18)));
            log.info("Preloading " + repository.save(
                    new Round(LocalDate.of(2023, 10, 6), "Lisheen Springs", "Yellow", 126, (long) 71.8, 115, 0, (long) 26.7, 18)));
            log.info("Preloading " + repository.save(
                    new Round(LocalDate.of(2023, 10, 14), "Lisheen Springs", "Yellow", 126, (long) 71.8, 127, 2, (long) 35.7, 18)));
        };
    }
}

