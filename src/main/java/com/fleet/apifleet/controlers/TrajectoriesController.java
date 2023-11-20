package com.fleet.apifleet.controlers;

import com.fleet.apifleet.repository.TrajectoriesRepository;
import com.fleet.apifleet.models.Trajectories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("trajectories")

public class TrajectoriesController {
    @Autowired
    private TrajectoriesRepository repository;
    @GetMapping("/")
    public List<Trajectories> list(@RequestParam Integer taxi_id) {
        return repository.listTrajectories(taxi_id);
    }

    @GetMapping("/ultimo")
    public List<Trajectories> ultimo(@RequestParam Integer taxi_id) {
        return repository.ultimaUbicacion(taxi_id);
    }


    @GetMapping("/ultimoReporte")
    public List<Trajectories> ultimoReporte() {
        return repository.ultimaUbucacionReportada();
    }

}