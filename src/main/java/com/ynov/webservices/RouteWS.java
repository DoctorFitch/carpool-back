package com.ynov.webservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.model.Route;
import com.ynov.repository.RouteRepository;

//API DOCUMENTATION HERE : https://carpool-ynov.herokuapp.com/swagger-ui.html

@RestController
@RequestMapping("/carpool")
public class RouteWS {

	@Autowired
	private RouteRepository routeRepository;

	// GET ALL ROUTES
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/routes", method = RequestMethod.GET)
	public List<Route> getRoutes() {

		return routeRepository.findAll();
	}

	// GET ROUTE BY ID
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/routes/{id}", method = RequestMethod.GET)
	public Route getRouteById(@PathVariable("id") String id) {

		Optional<Route> route = routeRepository.findById(id);

		return route.get();
	}

	// CREATED ROUTE
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/routes", method = RequestMethod.POST)
	public Route createRoute(@RequestBody Route route) throws Exception {

		routeRepository.save(route);

		return route;
	}

	// UPDATED ROUTE
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/routes", method = RequestMethod.PUT)
	public Route updateRoute(@RequestBody Route route) throws Exception {

		boolean routeExist = routeRepository.findById(route.getId()).isPresent();

		if (routeExist) {
			// update
			routeRepository.save(route);
		} else {
			throw new java.lang.Error("Route not exist");
		}

		return route;
	}

	// DELETED ROUTE
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/routes", method = RequestMethod.DELETE)
	public Route deleteRoute(@RequestBody Route route) throws Exception {

		boolean routeExist = routeRepository.findById(route.getId()).isPresent();

		if (routeExist) {
			// update
			routeRepository.delete(route);
		} else {
			throw new java.lang.Error("Route not exist");
		}

		return route;
	}

}
