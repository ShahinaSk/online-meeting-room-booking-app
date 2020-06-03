package com.brillio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Room")
public class Room {
    @Id
    private int roomId;
    //    private String roomName;
    private String roomType;
    private Floor floor;
    private boolean available;


}
