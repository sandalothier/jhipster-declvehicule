package com.fisc.declvehicule.web.rest;

import com.fisc.declvehicule.service.DeclvehiculeKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declvehicule-kafka")
public class DeclvehiculeKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclvehiculeKafkaResource.class);

    private DeclvehiculeKafkaProducer kafkaProducer;

    public DeclvehiculeKafkaResource(DeclvehiculeKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
