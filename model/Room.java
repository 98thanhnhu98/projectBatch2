package com.example.Project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roomid")
    private long roomid;
    @Basic
    @Column(name = "categoryid")
    private Long categoryid;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "price")
    private Integer price;
    @Basic
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "sale_id")
    private Long saleId;
    @Basic
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "roomByRoomid")
    private Collection<Tenancy> tenanciesByRoomid;
    @ManyToOne
    @JoinColumn(name = "categoryid", insertable = false, updatable = false, referencedColumnName = "id")
    private Category categoryByCategoryid;
    @ManyToOne
    @JoinColumn(name = "sale_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Sale saleBySaleId;

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


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
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

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomid != room.roomid) return false;
        if (categoryid != null ? !categoryid.equals(room.categoryid) : room.categoryid != null) return false;
        if (title != null ? !title.equals(room.title) : room.title != null) return false;
        if (price != null ? !price.equals(room.price) : room.price != null) return false;
        if (thumbnail != null ? !thumbnail.equals(room.thumbnail) : room.thumbnail != null) return false;
        if (description != null ? !description.equals(room.description) : room.description != null) return false;
        if (status != null ? !status.equals(room.status) : room.status != null) return false;
        if (saleId != null ? !saleId.equals(room.saleId) : room.saleId != null) return false;
        if (address != null ? !address.equals(room.address) : room.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roomid ^ (roomid >>> 32));
        result = 31 * result + (categoryid != null ? categoryid.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (saleId != null ? saleId.hashCode() : 0);
        return result;
    }

    public Collection<Tenancy> getTenanciesByRoomid() {
        return tenanciesByRoomid;
    }

    public void setTenanciesByRoomid(Collection<Tenancy> tenanciesByRoomid) {
        this.tenanciesByRoomid = tenanciesByRoomid;
    }

    public Category getCategoryByCategoryid() {
        return categoryByCategoryid;
    }

    public void setCategoryByCategoryid(Category categoryByCategoryid) {
        this.categoryByCategoryid = categoryByCategoryid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sale getSaleBySaleId() {
        return saleBySaleId;
    }

    public void setSaleBySaleId(Sale saleBySaleId) {
        this.saleBySaleId = saleBySaleId;
    }
}
