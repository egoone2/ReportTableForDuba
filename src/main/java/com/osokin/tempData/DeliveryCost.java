package com.osokin.tempData;

import com.osokin.orders.OrderIFB;
import com.osokin.region.Region;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeliveryCost {
    private static int count = 2;
    private double productPrice;
    private double declaredValue;
    private int baseRate;
    private int extraKgPrice;
    private int extraPrice;
    private double deliveryPrice;

    public DeliveryCost(OrderIFB orderIFB) {
        count++;
        this.productPrice = orderIFB.getSum() - orderIFB.getDeliveryCost();
        this.declaredValue = 0.005 * productPrice;
        Region region = orderIFB.getRegion();
        this.baseRate = region.getBaseRate();
        this.extraKgPrice = region.getCostPerAdditionalKg();
        this.extraPrice = getExtraPrice(orderIFB);
        this.deliveryPrice = declaredValue + baseRate + extraPrice;
        System.out.println(count + " " + this);
    }

    private int getExtraPrice(OrderIFB orderIFB) {
        double weight = orderIFB.getWeight();
        return countExtraKg(weight) * extraKgPrice;
    }

    private int countExtraKg(double weight) {
        if (weight < 3) return 0;
        double diff = weight - 3;
        return (int) Math.ceil(diff);
    }

    @Override
    public String toString() {
        return "DeliveryCost{" +
                "Цена товаров=" + productPrice +
                ", Объявленная ценность=" + declaredValue +
                ", Базовый тариф=" + baseRate +
                ", Цена за доп кг=" + extraKgPrice +
                ", Доплата за доп кг=" + extraPrice +
                ", Цена доставки=" + deliveryPrice +
                '}';
    }
}
