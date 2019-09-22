package com.trilogyed.Hotelbookingservice.model;

import java.util.Objects;

public class HotelBooking {

    private int id;
    private boolean rewardsMember;
    private float finalCost;
    private int totalRewardsPoints;
    private boolean doubleBonusDay;

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public int getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(int totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    public boolean isDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    //Equal and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelBooking that = (HotelBooking) o;
        return id == that.id &&
                rewardsMember == that.rewardsMember &&
                Float.compare(that.finalCost, finalCost) == 0 &&
                totalRewardsPoints == that.totalRewardsPoints &&
                doubleBonusDay == that.doubleBonusDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rewardsMember, finalCost, totalRewardsPoints, doubleBonusDay);
    }
}
