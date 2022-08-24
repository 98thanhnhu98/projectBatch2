package com.example.Project.Service;

import com.example.Project.model.Room;
import com.example.Project.repository.RoomPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomPJServiceIML implements RoomPJService{
    @Autowired
    RoomPJRepository roomPJRepository;
    @Override
    public List<Room> getAll() {
        return roomPJRepository.findAll();
    }

    @Override
    public void saveClass(Room room) {
        roomPJRepository.save(room);
    }

    @Override
    public void deleteRoom(long id) {
        roomPJRepository.findById(id);
    }

    @Override
    public Optional<Room> findRoomById(long id) {
        return roomPJRepository.findById(id);
    }

    @Override
    public Room getOne(long id) {
        return roomPJRepository.findRoomByRoomid(id);
    }
    @Override
    public List<Room> findRoomsByCaategoryid(long id) {
        return roomPJRepository.findRoomsByCategoryid(id);
    }

    @Override
    public List<Room> findRoomsByyTitle(String title) {
        return roomPJRepository.findRoomsByTitle(title);
    }

    @Override
    public List<Room> findRoomsByyStatus(int status) {
        return roomPJRepository.findRoomsByStatus(status);
    }

    @Override
    public Page<Room> findRoom(Pageable pageable) {
        return roomPJRepository.findAll(pageable);
    }


}
