package com.cittamobi.project.service;

import com.cittamobi.project.model.VehicleData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@Service
public class CittaMobiService {

    private final String URL = "https://api.cittamobi.com.br/m3p/js/prediction/stop/5208036,5195544";

    public Object getVehicles() {
        List<VehicleData> vehicleDataList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Object> request = new RequestEntity<>(HttpMethod.GET, URI.create(URL));
        ResponseEntity<Map> response = restTemplate.exchange(request, Map.class);
        ArrayList<Map> data = (ArrayList<Map>) response.getBody().get("services");
        data.forEach(s -> {
            ObjectMapper objectMapper = new ObjectMapper();
            VehicleData vehicleData = objectMapper.convertValue(s, VehicleData.class);
            if (!vehicleData.getVehicles().isEmpty()) {
                vehicleDataList.add(vehicleData);
            }
        });
        Collections.sort(vehicleDataList, Comparator.comparing(VehicleData::getRouteMnemonic));
        return vehicleDataList;
    }
}
