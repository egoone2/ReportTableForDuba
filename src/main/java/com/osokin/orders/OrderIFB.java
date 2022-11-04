package com.osokin.orders;

import lombok.Data;
import com.osokin.dto.OrderIFBDTO;
import com.osokin.exceptions.RegionNameException;
import com.osokin.region.Region;
import com.osokin.region.RegionCity;

import java.util.Date;
@Data
public class OrderIFB {
    private int clientDataNumber;
    private Date issueDate;
    private String mpSiteFlag;
    private double weight;
    private Region region;
    private String city;
    private double sum;
    private double deliveryCost;

    public void setRegion(String region, boolean isCity) throws RegionNameException {
        RegionCity regionCity = new RegionCity(region, isCity);
        this.region = Region.getRegionMap().get(regionCity);
    }
    public OrderIFB() {

    }

    public OrderIFB(OrderIFBDTO dto) {
        this.city = dto.getCity();
        this.region = dto.getRegion();
        this.deliveryCost = dto.getDeliveryCost();
        this.sum = dto.getSum();
        this.weight = dto.getWeight();
        this.issueDate = dto.getIssueDate();
        this.mpSiteFlag = dto.getMpSiteFlag();
        this.clientDataNumber = dto.getClientDataNumber();
    }

}
