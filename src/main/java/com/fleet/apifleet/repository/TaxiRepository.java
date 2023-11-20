package com.fleet.apifleet.repository;


import com.fleet.apifleet.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi,Integer> {

}
