package com.brillio.prefill;

import com.brillio.domain.Room;
import com.brillio.service.RoomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class MyApplication implements CommandLineRunner {

    RoomService roomService;

    @Autowired
    public MyApplication(RoomService roomService) {
        this.roomService = roomService;
    }

    @Bean
    CommandLineRunner runner(RoomService roomService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Room>> typeReference = new TypeReference<List<Room>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
            try {
                List<Room> rooms = mapper.readValue(inputStream, typeReference);
                roomService.save(rooms);
                System.out.println("Rooms Saved!\t" + rooms);
            } catch (IOException e) {
                System.out.println("Unable to save rooms: " + e.getMessage());
            }
        };
    }

    @Override
    public void run(String... args) {
        runner(roomService);
    }
}
