package com.ynov.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ynov.model.Route;

@Repository
public interface RouteRepository extends MongoRepository<Route,String> {

	Optional<Route> findById(String id);
}
