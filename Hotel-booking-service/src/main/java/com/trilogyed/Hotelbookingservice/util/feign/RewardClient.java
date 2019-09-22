package com.trilogyed.Hotelbookingservice.util.feign;


import com.trilogyed.Hotelbookingservice.model.Rewards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "rewards-service")
public interface RewardClient {
    @RequestMapping(value = "/rewards/type/{roomType}", method = RequestMethod.GET)
    public Rewards getRewards(@PathVariable String roomType);

    @RequestMapping(value = "rewards", method = RequestMethod.GET)
    public List<Rewards> getAllRewards();
}
