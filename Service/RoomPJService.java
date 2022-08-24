package com.example.Project.Service;

import com.example.Project.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomPJService {
    List<Room> getAll();
    void saveClass(Room room);
    void deleteRoom(long id);
    Optional<Room> findRoomById(long id);
    Room getOne(long id);
    List<Room> findRoomsByCaategoryid(long id);
    List<Room> findRoomsByyTitle(String title);
    List<Room> findRoomsByyStatus(int status);

    Page<Room> findRoom(Pageable pageable);

}
