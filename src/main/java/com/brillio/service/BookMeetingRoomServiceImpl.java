package com.brillio.service;

import com.brillio.domain.BookMeetingRoom;
import com.brillio.domain.Room;
import com.brillio.repository.BookMeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BookMeetingRoomServiceImpl implements BookMeetingRoomService {
    private BookMeetingRoomRepository bookMeetingRoomRepository;
    private RoomService roomService;

    @Autowired
    public BookMeetingRoomServiceImpl(BookMeetingRoomRepository bookMeetingRoomRepository, RoomService roomService) {
        this.bookMeetingRoomRepository = bookMeetingRoomRepository;
        this.roomService = roomService;
    }

    @Override
    public BookMeetingRoom makeBooking(Integer roomId) {
        Room room = roomService.findById(roomId);
        if (room != null && room.isAvailable()) {
            BookMeetingRoom bookMeetingRoom = new BookMeetingRoom();
            bookMeetingRoom.setRoom(room);
            room.setAvailable(false);
            roomService.updateRoomAvailability(roomId);
            Random random=new Random();
            bookMeetingRoom.setBookingId(random.nextInt(Integer.MAX_VALUE));
            bookMeetingRoom.setBookingStatus(true);
            bookMeetingRoomRepository.save(bookMeetingRoom);
            System.out.println(bookMeetingRoom);
            return bookMeetingRoom;
        }
        return null;
    }

    @Override
    public String cancelBooking(Integer bookingId) {
        Optional optional = bookMeetingRoomRepository.findById(bookingId);
        if (optional.isPresent()) {
            BookMeetingRoom bookMeetingRoom = (BookMeetingRoom) optional.get();
            bookMeetingRoomRepository.delete(bookMeetingRoom);
            roomService.updateRoomAvailability(bookMeetingRoom.getRoom().getRoomId());
            return "Meeting Room Booking Cancelled Successfully";
        }
        return "Booking Cancellation Failed!";
    }


}
