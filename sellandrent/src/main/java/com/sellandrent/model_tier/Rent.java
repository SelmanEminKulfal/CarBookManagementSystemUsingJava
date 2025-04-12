package com.sellandrent.model_tier;

import java.sql.Date;

public class Rent {
    private int id;
    private int vehicleId;
    private int customerId;
    private Date startDate;
    private Date endDate;

    public Rent(int id, int vehicleId, int customerId, Date startDate, Date endDate) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rent() {
		// TODO Auto-generated constructor stub
	}

	// Getter ve setter metotları
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}