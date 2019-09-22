package com.trilogyed.Hotelbookingservice.controller;


import com.trilogyed.Hotelbookingservice.service.HotelBookingService;
import com.trilogyed.Hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotelRewards")
public class HotelBookingController {

    @Autowired
    HotelBookingService hotelBookingService;

    @GetMapping(value = {"/{roomId}?rewardsMember={rewardsMember}&doubleBonusDay={doubleBonusDay}", "/{roomId}"})
    public HotelBookingViewModel getRates(@PathVariable(name = "roomId") int roomId,
                                          @RequestParam(defaultValue = "false", required = false) boolean rewardsMember,
                                          @RequestParam(defaultValue = "false", required = false) boolean doubleBonusDay) {

        return hotelBookingService.getRate(roomId, rewardsMember, doubleBonusDay);
    }
}
