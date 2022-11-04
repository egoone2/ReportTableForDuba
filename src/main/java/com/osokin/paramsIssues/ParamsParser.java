package com.osokin.paramsIssues;

import com.osokin.orders.Order5Post;
import com.osokin.orders.OrderIFB;
import com.osokin.dto.Order5PostDTO;
import com.osokin.dto.OrderIFBDTO;
import com.osokin.exceptions.RegionNameException;
import com.osokin.resultData.ResultForOneOrder;
import com.osokin.tempData.Calculator;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ParamsParser {
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    public static final NumberFormat nf = NumberFormat.getInstance();

    public void parseAndSendParams(String[] paramsArr, List<ResultForOneOrder> list) throws RegionNameException, ParseException {
        Order5Post order5Post = new Order5Post(getOrder5PostDTO(paramsArr));
        OrderIFB orderIFB = new OrderIFB(getOrderIFBDTO(paramsArr));
        Calculator calculator = new Calculator(order5Post, orderIFB, new ResultForOneOrder());
        calculator.setFields();
        list.add(calculator.getResultForOneOrder());
    }

    private Order5PostDTO getOrder5PostDTO(String[] params) throws ParseException {
        Order5PostDTO dto = new Order5PostDTO();
        dto.setClientDataNumber(Integer.parseInt(params[0]));
        dto.setDeliveryCost(nf.parse(params[1]).doubleValue());
        return dto;
    }

    private OrderIFBDTO getOrderIFBDTO(String[] params) throws ParseException, RegionNameException {
        OrderIFBDTO dto = new OrderIFBDTO();
        dto.setClientDataNumber(Integer.parseInt(params[3]));
        dto.setIssueDate(formatter.parse(params[4]));
        dto.setMpSiteFlag(params[5]);
        dto.setWeight(nf.parse(deleteSpaces(params[6])).doubleValue());
        dto.setRegion(params[7], params[8]);
        dto.setCity(params[8]);
        dto.setSum(nf.parse(deleteSpaces(params[9])).doubleValue());
        dto.setDeliveryCost(nf.parse(deleteSpaces(params[10])).doubleValue());
        return dto;
    }

    private String deleteSpaces(String line) {
        return line.replaceAll("\\s","");
    }
}
