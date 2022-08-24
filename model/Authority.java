package com.example.Project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Authority {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "authorityByAuthorityId_0")
    private Collection<Users> usersById_0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (id != authority.id) return false;
        if (name != null ? !name.equals(authority.name) : authority.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<Users> getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Collection<Users> usersById_0) {
        this.usersById_0 = usersById_0;
    }
}
