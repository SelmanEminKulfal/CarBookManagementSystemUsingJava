package com.sellandrent.model_tier;

public class Motorcycle extends Vehicle {
	private String engineType;
    private boolean hasSidecar;
	public Motorcycle(int id, String brand, String model, int year, String engineType, boolean hasSidecar) {
		super(id, brand, model, year);
		this.engineType = engineType;
        this.hasSidecar = hasSidecar;
	}

	@Override
	public void displayDetails() {
		System.out.println("Araç Türü: Motosiklet");
        System.out.println("Marka: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Yıl: " + getYear());
        System.out.println("Motor Tipi: " + engineType);
        System.out.println("Yan Sepetli mi: " + (hasSidecar ? "Evet" : "Hayır"));

	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType=engineType;
	}
	public boolean getHasSidecar() {
		return hasSidecar;
	}
	public void setHasSidecar(boolean hasSidecar) {
		this.hasSidecar=hasSidecar;
	}
}
