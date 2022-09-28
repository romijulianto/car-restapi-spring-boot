package com.romijulianto.restapicarspringboot.entities;

import com.romijulianto.restapicarspringboot.audit.AuditableBase;

import javax.persistence.*;

@Entity // to specific this class entity
@Table(name = "car") // this class to definition table using jpa to db
public class CarEntity extends AuditableBase {

    /* initiate attribute table */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String carName;
    private String type;
    private String number;
    private String color;


    /* create getter setter */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /* generated toString */

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
