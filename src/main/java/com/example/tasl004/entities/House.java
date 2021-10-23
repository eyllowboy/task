package com.example.tasl004.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
@Table(name = "house")
@SQLDelete(sql = "UPDATE house SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name should be not Null ")

    private String name;

    @Positive(message = "area should be positive")
    private int area;

    @Positive(message = "amount of rooms should be positive")
    private int amountOfRooms;

    private boolean deleted = Boolean.FALSE;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name", referencedColumnName = "id")
    private User user;

    public House() {
    }



    public House(Long id, String name, int area, int amountOfRooms, boolean deleted) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.amountOfRooms = amountOfRooms;
        this.deleted = deleted;
    }

    public House(Long id, String name, int area, int amountOfRooms, boolean deleted, User user) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.amountOfRooms = amountOfRooms;
        this.deleted = deleted;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public void setAmountOfRooms(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", amountOfRooms=" + amountOfRooms +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return area == house.area && amountOfRooms == house.amountOfRooms && deleted == house.deleted && Objects.equals(name, house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, amountOfRooms, deleted);
    }
}
