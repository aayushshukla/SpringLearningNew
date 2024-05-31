package com.infosys.diexample1.beans;

public class Vehicle {
	
	String modelName;
	double mileage;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public void showVehicleDetails()
	{
		System.out.println("Model name "+this.getModelName());
		System.out.println("Mileage is"+this.getMileage());
	}

}
