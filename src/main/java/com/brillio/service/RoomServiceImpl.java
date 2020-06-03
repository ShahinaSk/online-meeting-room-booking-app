package com.brillio.service;

import com.brillio.domain.Room;
import com.brillio.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(Integer roomId) {
        Optional optional = roomRepository.findById(roomId);
        return (Room) optional.get();
    }

    @Override
    public Iterable<Room> save(List<Room> rooms) {
        return roomRepository.saveAll(rooms);
    }

    @Override
    public List listAvailableRooms(String roomType, String buildingName, int floorNo) {
        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(room -> {
            if (room.isAvailable() && room.getFloor().getFloorNo() == floorNo) {
                rooms.add(room);
            }
        });
        return rooms;
    }

    @Override
    public List listAvailableRooms(String roomType, String buildingName) {

        List<Room> rooms = new ArrayList<>();
        roomRepository.findAll().forEach(room -> {
            if (room.isAvailable()) {
                rooms.add(room);
            }
        });
        System.out.println(rooms);
        return rooms;
    }

    @Override
    public Room updateRoomAvailability(Integer roomId) {
        Optional optional = roomRepository.findById(roomId);
        Room room = null;
        if (optional.isPresent()) {
            room = (Room) optional.get();
            if (room.isAvailable())
                room.setAvailable(false);
            else room.setAvailable(true);
            roomRepository.save(room);
            System.out.println(room);
        }
        System.out.println(room);
        return room;
    }
}
