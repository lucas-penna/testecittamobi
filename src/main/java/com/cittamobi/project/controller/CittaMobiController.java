package com.cittamobi.project.controller;

import com.cittamobi.project.service.CittaMobiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cittamobi")
public class CittaMobiController {

    @Autowired
    private CittaMobiService service;

    @GetMapping
    public ResponseEntity<?> getVehicles() {

        return ResponseEntity.ok(service.getVehicles());
    }
}
