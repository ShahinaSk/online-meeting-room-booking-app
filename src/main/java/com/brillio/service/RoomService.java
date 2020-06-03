package com.brillio.service;

import com.brillio.domain.Room;

import java.util.List;

public interface RoomService {
    Room findById(Integer roomId);

    Iterable<Room> save(List<Room> rooms);

    List listAvailableRooms(String roomType, String buildingName, int floor);

    List listAvailableRooms(String roomType, String buildingName);

    Room updateRoomAvailability(Integer roomId);

}
