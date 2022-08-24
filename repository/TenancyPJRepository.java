package com.example.Project.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Tenancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenancyPJRepository extends JpaRepository<Tenancy, Long> {
    @Query("select new com.example.Project.dto.userTenancyRoom(t.userId,t.roomid,u.fullname,u.email,t.note,t.orderdate,t.stardate,t.enddate,t.totalmonth,r.title,r.price,r.thumbnail,r.description) from Tenancy t inner join Room r On r.roomid = t.roomid inner join Users u on u.usersId = t.userId where u.usersId = :usersId")
    public List<userTenancyRoom> getInformation(Long usersId);

}
