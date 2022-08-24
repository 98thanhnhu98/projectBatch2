package com.example.Project.model;

import javax.persistence.*;

@Entity
public class Feedback {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "userid")
    private Long userid;
    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false, referencedColumnName = "users_id")
    private Users usersByUserid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (id != feedback.id) return false;
        if (note != null ? !note.equals(feedback.note) : feedback.note != null) return false;
        if (userid != null ? !userid.equals(feedback.userid) : feedback.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }

    public Users getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }
}
