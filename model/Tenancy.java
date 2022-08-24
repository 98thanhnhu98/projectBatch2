package com.example.Project.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tenancy")
public class Tenancy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rentalid")
    private long rentalid;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "orderdate")
    private Date orderdate;
    @Basic
    @Column(name = "stardate")
    private Date stardate;
    @Basic
    @Column(name = "enddate")
    private Date enddate;
    @Basic
    @Column(name = "totalmonth")
    private Integer totalmonth;
    @Basic
    @Column(name = "roomid")
    private Long roomid;
    @OneToMany(mappedBy = "tenancyByTenancyid")
    private Collection<Fee> feesByRentalid;
    @ManyToOne
    @JoinColumn(name = "roomid", insertable = false, updatable = false, referencedColumnName = "roomid")
    private Room roomByRoomid;
    @Basic
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false,updatable = false, referencedColumnName = "users_id")
    private Users usersByUserId;

    public long getRentalid() {
        return rentalid;
    }

    public void setRentalid(long rentalid) {
        this.rentalid = rentalid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getStardate() {
        return stardate;
    }

    public void setStardate(Date stardate) {
        this.stardate = stardate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getTotalmonth() {
        return totalmonth;
    }

    public void setTotalmonth(Integer totalmonth) {
        this.totalmonth = totalmonth;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tenancy tenancy = (Tenancy) o;

        if (rentalid != tenancy.rentalid) return false;
        if (note != null ? !note.equals(tenancy.note) : tenancy.note != null) return false;
        if (orderdate != null ? !orderdate.equals(tenancy.orderdate) : tenancy.orderdate != null) return false;
        if (stardate != null ? !stardate.equals(tenancy.stardate) : tenancy.stardate != null) return false;
        if (enddate != null ? !enddate.equals(tenancy.enddate) : tenancy.enddate != null) return false;
        if (totalmonth != null ? !totalmonth.equals(tenancy.totalmonth) : tenancy.totalmonth != null) return false;
        if (roomid != null ? !roomid.equals(tenancy.roomid) : tenancy.roomid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (rentalid ^ (rentalid >>> 32));
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (stardate != null ? stardate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (totalmonth != null ? totalmonth.hashCode() : 0);
        result = 31 * result + (roomid != null ? roomid.hashCode() : 0);
        return result;
    }

    public Collection<Fee> getFeesByRentalid() {
        return feesByRentalid;
    }

    public void setFeesByRentalid(Collection<Fee> feesByRentalid) {
        this.feesByRentalid = feesByRentalid;
    }

    public Room getRoomByRoomid() {
        return roomByRoomid;
    }

    public void setRoomByRoomid(Room roomByRoomid) {
        this.roomByRoomid = roomByRoomid;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
