package com.br.store.controller.impl;

import com.br.store.controller.BikeController;
import com.br.store.model.Bike;
import com.br.store.repository.BikeRepository;
import com.br.store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BikeControllerImpl implements BikeController {

    @Autowired
    BikeService bikeService;

    @Override
    public String test() {
        return "Ok";
    }

    @Override
    public ResponseEntity bikeAll() {

        List<Bike> bikes = bikeService.returnBike();

        return new ResponseEntity(bikes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity bikeById(Long id) {
        Optional<Bike> bike = bikeService.returnBikeById(id);

        return new ResponseEntity(bike, HttpStatus.OK);
    }

    @Override
    public ResponseEntity createBike(Bike bike) {
        HttpStatus httpStatus = bikeService.createBike(bike);
        return new ResponseEntity(bike, httpStatus);
    }

    @Override
    public ResponseEntity updateBike(Bike bike, Long id) {
        HttpStatus httpStatus = bikeService.updateBike(id, bike);
        return new ResponseEntity(bike, httpStatus);

    }

    @Override
    public ResponseEntity deleteBike(Long id) {
        HttpStatus httpStatus = bikeService.deleteBike(id);
        return new ResponseEntity(httpStatus);
    }
}
