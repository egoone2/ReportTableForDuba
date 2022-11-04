package com.osokin.paramsIssues;

import com.osokin.exceptions.RegionNameException;
import com.osokin.resultData.ResultForOneOrder;

import java.text.ParseException;
import java.util.List;

public class ParamSender {
    private static final ParamsParser parser = new ParamsParser();

    public static void sendParamsLine(String paramsLine, List<ResultForOneOrder> list) throws RegionNameException, ParseException {
        String[] paramsArr = paramsLine.split("\t");
        parser.parseAndSendParams(paramsArr, list);
    }
}
