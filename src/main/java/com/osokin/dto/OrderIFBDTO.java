package com.osokin.dto;

import com.osokin.region.Region;
import lombok.Data;
import com.osokin.exceptions.RegionNameException;
import com.osokin.region.RegionCity;

import java.util.Date;
@Data
public class OrderIFBDTO {
    private int clientDataNumber;
    private Date issueDate;
    private String mpSiteFlag;
    private double weight;
    private Region region;
    private String city;
    private double sum;
    private double deliveryCost;


    public void setRegion(String region, String cityAddress) throws RegionNameException {
        RegionCity regionCity = new RegionCity(region, cityAddress);
        this.region = Region.getRegionMap().get(regionCity);
    }
}
