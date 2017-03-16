package com.example.service;

import com.example.domain.Hotel;
import com.example.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private CassandraOperations hotelRepository;

    /*public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }*/

    @Override
    public Hotel save(Hotel hotel) {
        return this.hotelRepository.insert(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return this.hotelRepository.insert(hotel);
    }

    @Override
    public Hotel findOne(UUID uuid) {
        //String cqlOne = "select * from hotels where id = " + uuid;

        String cqlOne = "select * from hotels where id = 62c36092-82a1-3a00-93d1-46196ee77204";
        return this.hotelRepository.selectOne(cqlOne, Hotel.class);
    }

    @Override
    public void delete(UUID uuid) {
        this.hotelRepository.delete(uuid);
    }
}
