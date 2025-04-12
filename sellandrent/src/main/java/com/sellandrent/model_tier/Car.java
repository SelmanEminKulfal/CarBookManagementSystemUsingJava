package com.sellandrent.model_tier;

public class Car extends Vehicle{
	private int numberOfDoors;
    private String fuelType;
	public Car(int id, String brand, String model, int year, int numberOfDoors, String fuelType) {
		super(id, brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
	}
	@Override
	public void displayDetails() {
		System.out.println("Araç Türü: Araba");
        System.out.println("Marka: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Yıl: " + getYear());
        System.out.println("Kapı Sayısı: " + numberOfDoors);
        System.out.println("Yakıt Tipi: " + fuelType);
	}
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors=numberOfDoors;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType=fuelType;
	}
}
