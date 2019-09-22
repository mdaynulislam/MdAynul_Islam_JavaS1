package com.trilogyed.Hotelbookingservice;

import com.trilogyed.Hotelbookingservice.model.Rewards;
import com.trilogyed.Hotelbookingservice.model.Room;
import com.trilogyed.Hotelbookingservice.service.HotelBookingService;
import com.trilogyed.Hotelbookingservice.util.feign.RewardClient;
import com.trilogyed.Hotelbookingservice.util.feign.RoomClient;
import com.trilogyed.Hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class HotelBookingServiceTest {

    RoomClient roomClient;
    RewardClient rewardClient;
    HotelBookingService hotelBookingService;

    @Before
    public void setUp() throws Exception {
        setUpRewardsClientMock();
        setUpRoomClientMock();
        hotelBookingService = new HotelBookingService(rewardClient, roomClient);
    }


    // getRate() - will test with various different combinations of values passed via url.
    @Test
    public void getRate() {
        // TEST IF USER IS A MEMBER, AND IT IS DOUBLE BONUS DAY
        HotelBookingViewModel hvm = new HotelBookingViewModel();
        hvm.setRoomId(2023);
        hvm.setRewardsMember(true);
        hvm.setDoubleBonusDay(true);
        hvm.setBaseRate(200.00f);
        hvm.setMemberDiscount(0.06f);
        hvm.setBaseRewardsPoints(2100);
        hvm.setCanDouble(true);
        hvm.setFinalCost(188);
        hvm.setTotalRewardsPoints(4200);

        HotelBookingViewModel fromService = hotelBookingService.getRate(2023,true, true);
        assertEquals(fromService, hvm);

        // TEST IF USER IS A MEMBER, BUT IT IS NOT DOUBLE BONUS DAY
        HotelBookingViewModel hvm1 = new HotelBookingViewModel();
        hvm1.setRoomId(2023);
        hvm1.setRewardsMember(true);
        hvm1.setDoubleBonusDay(false);
        hvm1.setBaseRate(200.00f);
        hvm1.setMemberDiscount(0.06f);
        hvm1.setBaseRewardsPoints(2100);
        hvm1.setCanDouble(true);
        hvm1.setFinalCost(188);
        hvm1.setTotalRewardsPoints(2100);

        HotelBookingViewModel fromService1 = hotelBookingService.getRate(2023, true, false);
        assertEquals(fromService1, hvm1);

        // TEST IF USER IS NOT MEMBER, AND IT IS NOT DOUBLE BONUS DAY
        HotelBookingViewModel hvm2 = new HotelBookingViewModel();
        hvm2.setRoomId(6021);
        hvm2.setRewardsMember(false);
        hvm2.setDoubleBonusDay(false);
        hvm2.setBaseRate(400.00f);
        hvm2.setMemberDiscount(0.10f);
        hvm2.setBaseRewardsPoints(3200);
        hvm2.setCanDouble(true);
        hvm2.setFinalCost(400.00f);
        hvm2.setTotalRewardsPoints(0);

        HotelBookingViewModel fromService2 = hotelBookingService.getRate(6021, false, false);
        assertEquals(fromService2, hvm2);
    }

    //getAllRewards() - will expect a list of all rewards available.
    @Test
    public void getAllRewards() {
        List<Rewards> rewardsList = rewardClient.getAllRewards();
        assertEquals(2, rewardsList.size());
    }

    //getAllRooms() - will expect a list of all rooms available.
    @Test
    public void getAllRooms() {
        List<Room> roomList = roomClient.getAllRooms();
        assertEquals(2, roomList.size());
    }
/************************************Dao Mock********************************************/

    private void setUpRoomClientMock() {
        roomClient = mock(RoomClient.class);

        Room room = new Room();
        room.setNumber(2023);
        room.setRoomType("King Double");
        room.setBaseRate(200.00f);

        Room room1 = new Room();
        room1.setNumber(6021);
        room1.setRoomType("Penthouse");
        room1.setBaseRate(400.00f);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room1);

        doReturn(room).when(roomClient).getRoom(2023);
        doReturn(room1).when(roomClient).getRoom(6021);
        doReturn(rooms).when(roomClient).getAllRooms();
    }

    private void setUpRewardsClientMock() {
        rewardClient = mock(RewardClient.class);

        Rewards rewards = new Rewards();
        rewards.setId(221);
        rewards.setPoints(2100);
        rewards.setCanDouble(true);
        rewards.setRoomType("King Double");
        rewards.setDiscount(0.06f);

        Rewards rewards1 = new Rewards();
        rewards1.setId(222);
        rewards1.setPoints(3200);
        rewards1.setCanDouble(true);
        rewards1.setRoomType("Penthouse");
        rewards1.setDiscount(0.10f);

        List<Rewards> rewardsList = new ArrayList<>();
        rewardsList.add(rewards);
        rewardsList.add(rewards1);

        doReturn(rewards).when(rewardClient).getRewards("King Double");
        doReturn(rewards1).when(rewardClient).getRewards("Penthouse");
        doReturn(rewardsList).when(rewardClient).getAllRewards();
    }

}
