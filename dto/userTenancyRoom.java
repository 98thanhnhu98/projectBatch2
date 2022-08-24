package com.example.Project.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class userTenancyRoom {
    private long usersId;
    private long roomid;

    private String fullname;
    private String email;

    private String note;
    private Date orderdate;
    private Date stardate;
    private Date enddate;
    private int totalmonth;

    private String title;
    private int price;

    private String thumbnail;
    private String description;
}
