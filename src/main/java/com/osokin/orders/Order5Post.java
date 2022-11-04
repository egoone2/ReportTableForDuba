package com.osokin.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.osokin.dto.Order5PostDTO;

@AllArgsConstructor
@Getter
public class Order5Post {
    private int clientDataNumber;
    private double deliveryCost;

    public Order5Post(Order5PostDTO dto) {
        this.clientDataNumber = dto.getClientDataNumber();
        this.deliveryCost = dto.getDeliveryCost();
    }
}
