package com.castlemon.golf;

import com.castlemon.golf.entity.Round;
import com.castlemon.golf.repository.RoundRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Configuration
class LoadDatabase {

    @Value("classpath:data/roundData.json")
    private Resource roundsFile;

    @Value("classpath:data/courseData.json")
    private Resource coursesFile;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RoundRepository roundRepository) throws IOException {
        int[] dummy = new int[0];
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);

        List<Round> rounds =
                objectMapper.readValue(roundsFile.getContentAsString(Charset.defaultCharset()), new TypeReference<>() {
                });
        log.info("Rounds size : " + rounds.size());
        return args -> {
            for (Round round : rounds) {
                roundRepository.save(round);
            }
            log.info("Preloaded all data");
        };
    }
}

