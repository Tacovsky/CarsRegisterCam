package com.example.dckurty.carsregistercam.models;

import com.orm.SugarRecord;

public class Car extends SugarRecord {

    private String plate, model, owner;
    private boolean done;

    public Car() {
    }

    public Car(String plate, String model, String owner, boolean done) {
        this.plate = plate;
        this.model = model;
        this.owner = owner;
        this.done = done;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
