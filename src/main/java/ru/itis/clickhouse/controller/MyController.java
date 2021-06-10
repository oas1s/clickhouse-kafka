package ru.itis.clickhouse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.clickhouse.dto.User;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        User user = User.builder().age(18).surname("Sidikov").name("Marsel").build();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            kafkaTemplate.send("testtopic", objectMapper.writeValueAsString(user));
            return "Message was sent successfully";
        } catch (Exception e) {
            return "Error catched while sending message to kafka" + e;
        }
    }
}
