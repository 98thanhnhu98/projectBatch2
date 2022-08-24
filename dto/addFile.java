package com.example.Project.dto;


import org.springframework.web.multipart.MultipartFile;

public class addFile {

    private long roomid;

    private Long categoryid;

    private String title;

    private Integer price;

    private Integer discount;

    private MultipartFile thumbnail;

    private String description;

    private Integer status;

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public MultipartFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MultipartFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public addFile(long roomid, Long categoryid, String title, Integer price, Integer discount, MultipartFile thumbnail, String description, Integer status) {
        this.roomid = roomid;
        this.categoryid = categoryid;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.thumbnail = thumbnail;
        this.description = description;
        this.status = status;
    }
}
