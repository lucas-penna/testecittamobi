package com.cittamobi.project.model;

import lombok.Data;

@Data
public class Message {

    public String text;
    public Long ts;
    public Long companyId;
    public String companyType;
    public String companyName;
}
