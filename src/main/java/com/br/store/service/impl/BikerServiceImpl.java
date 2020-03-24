package com.br.store.service.impl;

import com.br.store.model.Bike;
import com.br.store.repository.BikeRepository;
import com.br.store.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BikerServiceImpl implements BikeService {

    @Autowired
    BikeRepository bikeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Bike> returnBike() {
        List<Bike> bike = bikeRepository.findAll();
        return bike;
    }

    @Override
    @Transactional
    public HttpStatus createBike(Bike bike) {
        bikeRepository.save(bike);

        if (bikeRepository.findById(bike.getId()) == null) {
            return HttpStatus.I_AM_A_TEAPOT;
        }
        return HttpStatus.CREATED;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Bike> returnBikeById(Long id) {
        Optional<Bike> bike = bikeRepository.findById(id);
        return bike;
    }

    @Override
    public HttpStatus updateBike(Long id, Bike bike) {
        if (id == null) {
            return HttpStatus.NOT_FOUND;
        }
        bike.setId(id);
        bikeRepository.save(bike);

        return HttpStatus.ACCEPTED;
    }

    @Override
    public HttpStatus deleteBike(Long id) {
        if (id == null) {
            return HttpStatus.NOT_FOUND;
        }
        bikeRepository.deleteById(id);

        return HttpStatus.OK;
    }


}
