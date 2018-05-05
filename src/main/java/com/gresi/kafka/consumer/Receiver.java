package com.gresi.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class Receiver {


    /**
     * Ketu do te ruhet cdo mesazh qe vin nga serveri i kafka
     */
    private List<String> data = new ArrayList<>();


    /**
     * Degjon ne topc e kafkes me emrin "test"
     * emri i topic merret nga /resources/application.yml
     *
     * @param message
     */
    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {
        data.add(message);
        System.out.println(message);
    }


    /**
     * Perdoret vetem per te shfaqur te dhenat e array list me mesazhe
     * te krijuar me lart me emrin "data"
     * ne
     * http://localhost:8080
     */
    @RequestMapping("/")
    public List<String> getAllData(){
        return  data;
    }


}