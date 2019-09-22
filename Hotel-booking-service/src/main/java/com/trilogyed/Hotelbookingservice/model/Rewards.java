package com.trilogyed.Hotelbookingservice.model;

import java.util.Objects;

public class Rewards {

    private int id;
    private String roomType;
    private Float discount;
    private Integer points;
    private Boolean canDouble;

    //getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    //Equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return id == rewards.id &&
                roomType.equals(rewards.roomType) &&
                discount.equals(rewards.discount) &&
                points.equals(rewards.points) &&
                canDouble.equals(rewards.canDouble);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomType, discount, points, canDouble);
    }
}
