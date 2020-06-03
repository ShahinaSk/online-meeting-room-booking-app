package com.brillio.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Book Meeting Room")
public class BookMeetingRoom {
    @Id
    private int bookingId;
    private boolean bookingStatus;
    private Room room;
}
