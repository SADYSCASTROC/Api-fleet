package com.fleet.apifleet.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="taxis")
public class Taxi {
    @Id
    private Integer id;
    private String license;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Taxi() {

    }
}
