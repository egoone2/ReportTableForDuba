package com.osokin.resultData;

import lombok.Data;
import com.osokin.tempData.DeliveryCost;

@Data
public class ResultForOneOrder {
    private double actDeliveryCost;
    private double takenFromClient;
    private double ourMistake;
    private double diffWithAct;
    private double fivePostMistake;
    private DeliveryCost deliveryCost;

    @Override
    public String toString() {
        return
                "Стоимость в акте = " + actDeliveryCost + "\n" +
                        "Взяли с клиента = " + takenFromClient + "\n" +
                        "Наши ошибки = " + String.format("%.2f", ourMistake) + "\n" +
                        "Разница со счетом = " + String.format("%.2f", diffWithAct) + "\n" +
                        "Ошибка 5Post = " + String.format("%.3f", fivePostMistake);
    }

    public String[] getArr() {
        return new String[]{Double.toString(actDeliveryCost),
                Double.toString(takenFromClient),
                String.format("%.2f", ourMistake),
                "",
                String.format("%.2f", diffWithAct),
                String.format("%.3f", fivePostMistake)};
    }
}
