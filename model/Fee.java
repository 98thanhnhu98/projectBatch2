package com.example.Project.model;

import javax.persistence.*;

@Entity
public class Fee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "tenancyid")
    private long tenancyid;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "tenancyid", insertable = false, updatable = false, referencedColumnName = "rentalid", nullable = false)
    private Tenancy tenancyByTenancyid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTenancyid() {
        return tenancyid;
    }

    public void setTenancyid(long tenancyid) {
        this.tenancyid = tenancyid;
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

        Fee fee = (Fee) o;

        if (id != fee.id) return false;
        if (tenancyid != fee.tenancyid) return false;
        if (name != null ? !name.equals(fee.name) : fee.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (tenancyid ^ (tenancyid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Tenancy getTenancyByTenancyid() {
        return tenancyByTenancyid;
    }

    public void setTenancyByTenancyid(Tenancy tenancyByTenancyid) {
        this.tenancyByTenancyid = tenancyByTenancyid;
    }
}
