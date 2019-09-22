package com.trilogyed.Hotelbookingservice.service;

import com.trilogyed.Hotelbookingservice.exception.NotFoundException;
import com.trilogyed.Hotelbookingservice.model.HotelBooking;
import com.trilogyed.Hotelbookingservice.model.Rewards;
import com.trilogyed.Hotelbookingservice.model.Room;
import com.trilogyed.Hotelbookingservice.util.feign.RewardClient;
import com.trilogyed.Hotelbookingservice.util.feign.RoomClient;
import com.trilogyed.Hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelBookingService {
    //The two Feign
    private RewardClient rewardClient;
    private RoomClient roomClient;

    //constructor
    @Autowired
    public HotelBookingService(RewardClient rewardClient, RoomClient roomClient) {
        this.rewardClient = rewardClient;
        this.roomClient = roomClient;
    }

    public HotelBookingViewModel getRate(int roomId, boolean rewardsMember, boolean doubleBonusDay) {
        // GET ROOM BASED ON ID, GET REWARDS BASED ON ROOM-TYPE
        Room room = getRoom(roomId);
        Rewards rewards = getRewards(room.getRoomType());

        // CALCULATE VALUES
        float finalCost = calculateFinalCost(rewardsMember, room.getBaseRate(), rewards.getDiscount());
        int totalRewardsPoints = checkRewardsPoints(doubleBonusDay, rewardsMember, rewards);

        // SET VALUES
        HotelBooking hotelBooking = new HotelBooking();
        hotelBooking.setRewardsMember(rewardsMember);
        hotelBooking.setTotalRewardsPoints(totalRewardsPoints);
        hotelBooking.setDoubleBonusDay(doubleBonusDay);
        hotelBooking.setFinalCost(finalCost);

        return buildHotelBookingViewModel(hotelBooking, room, rewards);
    }

    // HELPER METHODS
// ===========================================================================================================
    private Room getRoom(int roomId) {
        Room room = roomClient.getRoom(roomId);
        if (room == null) {
            throw new NotFoundException("Sorry, we do not have a room with that number. Please try again.");
        } else {
            return room;
        }
    }

    private Rewards getRewards(String roomType) {
        return rewardClient.getRewards(roomType);
    }

    // calculate final cost based on membership status, and subsequently the discount rate
    private float calculateFinalCost(boolean isMember, float baseRate, float memberDiscount) {
        if (isMember) {
            return baseRate * (1 - memberDiscount);
        } else {
            return baseRate;
        }
    }

    // return points based on isMember. If member, calculate value based on isDoubleDay && canDouble
    // if not, total rewards points will be the baseRewardsPoints
    private int checkRewardsPoints(boolean isDouble, boolean isMember, Rewards rewards) {
        int totalRewardsPoints = 0;
        if (isMember) {
            if (isDouble && rewards.getCanDouble()) {
                totalRewardsPoints = rewards.getPoints() * 2;
            } else {
                totalRewardsPoints = rewards.getPoints();
            }
        }
        return totalRewardsPoints;
    }

    private HotelBookingViewModel buildHotelBookingViewModel(HotelBooking hotelBooking, Room room, Rewards rewards) {
        HotelBookingViewModel hbvm = new HotelBookingViewModel();
        hbvm.setRoomId(room.getNumber());
        hbvm.setRewardsMember(hotelBooking.isRewardsMember());
        hbvm.setDoubleBonusDay(hotelBooking.isDoubleBonusDay());
        hbvm.setBaseRate(room.getBaseRate());
        hbvm.setMemberDiscount(rewards.getDiscount());
        hbvm.setBaseRewardsPoints(rewards.getPoints());
        hbvm.setCanDouble(rewards.getCanDouble());
        hbvm.setFinalCost(hotelBooking.getFinalCost());
        hbvm.setTotalRewardsPoints(hotelBooking.getTotalRewardsPoints());

        return hbvm;
    }

}
