package com.br.store.controller;

import com.br.store.model.Bike;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@ResponseBody
@RequestMapping(path = "/")
public interface BikeController {

    @GetMapping(path = "/")
    String test();

    @GetMapping(path = "/bike")
    ResponseEntity bikeAll();

    @GetMapping(path = "/bike/{id}")
    ResponseEntity bikeById(@PathVariable Long id);

    @PostMapping(path = "/bike")
    ResponseEntity createBike(@RequestBody Bike bike);

    @PutMapping(path = "bike/{id}")
    ResponseEntity updateBike(@RequestBody Bike bike, @PathVariable Long id);

    @DeleteMapping(path = "bike/{id}")
    ResponseEntity deleteBike(@PathVariable Long id);

}
