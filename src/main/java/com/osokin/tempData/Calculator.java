package com.osokin.tempData;

import com.osokin.orders.Order5Post;
import com.osokin.orders.OrderIFB;
import com.osokin.resultData.ResultForOneOrder;
import lombok.Getter;


public class Calculator {
    private Order5Post order5Post;
    private OrderIFB orderIFB;
    @Getter
    private ResultForOneOrder resultForOneOrder;
    private DeliveryCost deliveryCost;

    public Calculator(Order5Post order5Post, OrderIFB orderIFB, ResultForOneOrder resultForOneOrder) {
        this.order5Post = order5Post;
        this.orderIFB = orderIFB;
        this.resultForOneOrder = resultForOneOrder;
        this.deliveryCost = new DeliveryCost(orderIFB);

    }

    public void setFields() {
        setSimpleFields();
        setComplexFields();
    }

    public void setSimpleFields() {
        resultForOneOrder.setActDeliveryCost(order5Post.getDeliveryCost());
        resultForOneOrder.setTakenFromClient(orderIFB.getDeliveryCost());
    }

    public void setComplexFields() {
        double takenFromClient = orderIFB.getDeliveryCost();
        double actDeliveryCost = order5Post.getDeliveryCost();
        resultForOneOrder.setDeliveryCost(deliveryCost);
        resultForOneOrder.setOurMistake(takenFromClient - deliveryCost.getDeliveryPrice());
        resultForOneOrder.setDiffWithAct(takenFromClient - actDeliveryCost);
        resultForOneOrder.setFivePostMistake(deliveryCost.getDeliveryPrice() - actDeliveryCost);
    }


}
