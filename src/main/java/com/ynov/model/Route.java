package com.ynov.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Route {

	@Id
	String id;
	int distance;
	int numberPassagers;
	Conditions conditions;
	
	public Route() { }
	
	public String getId() {
		return id;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getNumberPassagers() {
		return numberPassagers;
	}
	public void setNumberPassagers(int numberPassagers) {
		this.numberPassagers = numberPassagers;
	}
	public Conditions getConditions() {
		return conditions;
	}
	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}
}
