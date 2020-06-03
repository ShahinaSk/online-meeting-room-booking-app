package com.brillio.repository;

import com.brillio.domain.BookMeetingRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMeetingRoomRepository extends MongoRepository<BookMeetingRoom, Integer> {
}
