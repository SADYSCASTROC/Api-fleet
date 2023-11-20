package com.fleet.apifleet.controlers;

import com.fleet.apifleet.models.Taxi;
import com.fleet.apifleet.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("taxis")
public class TaxisController {

    @Autowired
    private TaxiRepository repository;

 @GetMapping("/")
    public List<Taxi> list(){
        return repository.findAll();
    }
}
