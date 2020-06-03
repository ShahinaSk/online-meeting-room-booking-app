package com.brillio.controller;

import com.brillio.domain.BookMeetingRoom;
import com.brillio.service.BookMeetingRoomService;
import com.brillio.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class BookMeetingRoomController {

    private BookMeetingRoomService bookMeetingRoomService;
    private RoomService roomService;

    @Autowired
    public BookMeetingRoomController(BookMeetingRoomService bookMeetingRoomService, RoomService roomService) {
        this.bookMeetingRoomService = bookMeetingRoomService;
        this.roomService = roomService;
    }

    @GetMapping({"app/{roomType}/{buildingName}/{floorNo}","app/{roomType}/{buildingName}"})
    public ResponseEntity<?> listAllAvailableRooms(@PathVariable String roomType, @PathVariable String buildingName, @PathVariable(required = false) Integer floorNo) {
        System.out.println("in controller get1 method!!");
        if (floorNo != null) {
            return new ResponseEntity<>(roomService.listAvailableRooms(roomType, buildingName, floorNo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(roomService.listAvailableRooms(roomType, buildingName), HttpStatus.OK);
        }
    }

    @PostMapping("app/{roomId}")
    public ResponseEntity<?> bookMeetingRoom(@PathVariable Integer roomId) {
        System.out.println("in controller post method!!");
        BookMeetingRoom bookMeetingRoom = bookMeetingRoomService.makeBooking(roomId);
        if (bookMeetingRoom == null) {
            return new ResponseEntity("Booking Meeting Room Failed!!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(bookMeetingRoom, HttpStatus.OK);
    }

    @DeleteMapping("app/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Integer bookingId) {
        System.out.println("in controller delete method!!");
        return new ResponseEntity<>(bookMeetingRoomService.cancelBooking(bookingId), HttpStatus.OK);
    }

}
