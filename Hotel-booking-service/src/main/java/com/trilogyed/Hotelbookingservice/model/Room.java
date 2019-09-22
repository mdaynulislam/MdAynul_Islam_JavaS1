package com.trilogyed.Hotelbookingservice.model;

import java.util.Objects;

public class Room {

    private int number;
    private String roomType;
    private Float baseRate;

    //getters and setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    //Equal and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number &&
                roomType.equals(room.roomType) &&
                baseRate.equals(room.baseRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, roomType, baseRate);
    }
}
