package com.brillio.service;

import com.brillio.domain.BookMeetingRoom;

public interface BookMeetingRoomService {
    BookMeetingRoom makeBooking(Integer roomId);

    String cancelBooking(Integer bookingId);

}
