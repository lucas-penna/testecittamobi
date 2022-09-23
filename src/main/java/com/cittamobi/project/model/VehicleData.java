package com.cittamobi.project.model;

import lombok.Data;

import java.util.List;

@Data
public class VehicleData {

    public String routeCode;
    public String routeMnemonic;
    public Long companyId;
    public Long stopId;
    public Long serviceId;
    public String serviceMnemonic;
    public String predictionType;
    public Long activeVehicles;
    public Long scheduledVehicles;
    public List<Message> messages;
    public List<Vehicle> vehicles;
    public boolean hasRealTime;

}
