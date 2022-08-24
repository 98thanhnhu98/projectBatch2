package com.example.Project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "users_id")
    private long usersId;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "authority_id")
    private Long authorityId;

    @OneToMany(mappedBy = "usersByUserid")
    private Collection<Feedback> feedbacksByUsersId;

    @ManyToOne
    @JoinColumn(name = "authority_id", insertable = false, updatable = false, referencedColumnName = "id")
    private Authority authorityByAuthorityId_0;

    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Tenancy> tenanciesByUsersId;

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (usersId != users.usersId) return false;
        if (fullname != null ? !fullname.equals(users.fullname) : users.fullname != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (authorityId != null ? !authorityId.equals(users.authorityId) : users.authorityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (usersId ^ (usersId >>> 32));
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (authorityId != null ? authorityId.hashCode() : 0);
        return result;
    }

    public Collection<Feedback> getFeedbacksByUsersId() {
        return feedbacksByUsersId;
    }

    public void setFeedbacksByUsersId(Collection<Feedback> feedbacksByUsersId) {
        this.feedbacksByUsersId = feedbacksByUsersId;
    }

    public Authority getAuthorityByAuthorityId_0() {
        return authorityByAuthorityId_0;
    }

    public void setAuthorityByAuthorityId_0(Authority authorityByAuthorityId_0) {
        this.authorityByAuthorityId_0 = authorityByAuthorityId_0;
    }

    public Collection<Tenancy> getTenanciesByUsersId() {
        return tenanciesByUsersId;
    }

    public void setTenanciesByUsersId(Collection<Tenancy> tenanciesByUsersId) {
        this.tenanciesByUsersId = tenanciesByUsersId;
    }
}
