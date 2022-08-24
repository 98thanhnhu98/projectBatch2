package com.example.Project.repository;


import com.example.Project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersPJRepository extends JpaRepository<Users, Long> {
    List<Users> findUsersByFullname (String name);
//    Optional<Users> findByEmail (String email);
    Optional<Users> findByEmail(String email);
    List<Users> findByFullnameContaining(String fullname);
//    Users findByEmail(String email);
//,r.title,r.price,r.discount,r.thumbnail,r.description
    Users findUsersByEmail(String email);
//    @Query("SELECT * from Users bs where")

//    @Query("select new com.example.Project.dto.userTenancyRoom(u.fullname,u.email,t.note,t.orderdate,t.enddate,t.totalmonth,r.title,r.price,r.thumbnail,r.description) from Users u " +
//            "inner join Room r inner join Tenancy t  where u.usersId = :usersId")
//    @Query("select new com.example.Project.dto.userTenancyRoom(u.usersId,t.rentalid,r.roomid,u.fullname,u.email,t.note,t.orderdate,t.stardate,t.enddate,t.totalmonth,r.title,r.price,r.thumbnail,r.description) from Users u inner join Room r On u.roomid = r.roomid inner join Tenancy t on u.rentalid = t.rentalid where u.usersId = :usersId")
//    public List<userTenancyRoom> getInformation(Long usersId);
}
