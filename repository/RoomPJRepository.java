package com.example.Project.repository;

import com.example.Project.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RoomPJRepository extends JpaRepository<Room, Long>
{
    List<Room> findRoomsByCategoryid (long id);
    List<Room> findRoomsByTitle (String title);
    List<Room> findRoomsByStatus(int status);

    Room findRoomByRoomid(long id);

    Page<Room> findAll(Pageable pageable);

}