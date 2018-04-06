package com.ynov.model;

public class Conditions {
	
	boolean isSmoker;
	boolean isMusicalLover;
	boolean pet;
	
	public Conditions() { }
	
	public boolean isSmoker() {
		return isSmoker;
	}
	public void setSmoker(boolean isSmoker) {
		this.isSmoker = isSmoker;
	}
	public boolean isMusicalLover() {
		return isMusicalLover;
	}
	public void setMusicalLover(boolean isMusicalLover) {
		this.isMusicalLover = isMusicalLover;
	}
	public boolean isPet() {
		return pet;
	}
	public void setPet(boolean pet) {
		this.pet = pet;
	}
}
