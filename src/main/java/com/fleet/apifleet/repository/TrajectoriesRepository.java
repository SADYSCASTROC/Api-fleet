package com.fleet.apifleet.repository;


import com.fleet.apifleet.models.Trajectories;
import com.fleet.apifleet.models.Trajectories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {
    @Query(value = "SELECT * FROM trajectories t WHERE t.taxi_id = :taxi_id", nativeQuery = true)
    List<Trajectories> listTrajectories(@Param("taxi_id") Integer taxi_id);


    @Query(value = "select * from trajectories as t where \n" +
            "t.id = (select max(id) from trajectories as tr where tr.taxi_id=:taxi_id) \n" +
            "and t.taxi_id=:taxi_id", nativeQuery = true)
    List<Trajectories> ultimaUbicacion(@Param("taxi_id") Integer taxi_id);

    @Query(value = "SELECT DISTINCT ON (trajectories.taxi_id) taxis.id, taxis.license, trajectories.taxi_id," +
            " trajectories.date, trajectories.latitude, trajectories.longitude FROM taxis JOIN trajectories ON " +
            "taxis.id = trajectories.taxi_id ORDER BY trajectories.taxi_id, trajectories.date DESC ", nativeQuery = true)
    List<Trajectories> ultimaUbucacionReportada();
}