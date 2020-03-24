package com.br.store.service;

import com.br.store.model.Bike;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface BikeService {

    List<Bike> returnBike();

    HttpStatus createBike(Bike bike);

    Optional<Bike> returnBikeById(Long id);

    HttpStatus updateBike(Long id, Bike bike);

    HttpStatus deleteBike(Long id);
}
