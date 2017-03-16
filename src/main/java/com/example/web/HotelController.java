package com.example.web;

import com.example.domain.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by I831921 on 7/18/2016.
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @RequestMapping(path = "/v1/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable("id") String uuid) {

        UUID uuid2= UUID.randomUUID();

        System.out.println("----------------------------");
        System.out.println(uuid2);
        System.out.println("----------------------------");
        return this.hotelService.findOne(uuid2);
    }
}
