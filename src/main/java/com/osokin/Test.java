package com.osokin;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static final NumberFormat nf = NumberFormat.getInstance();

    public static boolean test(String excel, String myApp) throws ParseException {
        String[] excelArr = getNumArr(excel);
        String[] myAppArr = getNumArr(myApp);
        for (int i = 0; i < excelArr.length; i++) {
            if (i < 2 && !compareTwo(excelArr[i], myAppArr[i]))
                return true;
            else if (i == 3) {
            }
            else if (!compareTwoIfCommas(excelArr[i], myAppArr[i])) return true;
        }
        return false;
    }


    public static String[] getNumArr(String line) {
        return line.split("\t");
    }

    public static boolean compareTwo(String first, String second) throws ParseException {
        double firstD = nf.parse(first).doubleValue();
        double secondD = Double.parseDouble(second);
        return firstD == secondD;
    }

    public static boolean compareTwoIfCommas(String first, String second) throws ParseException {
        double firstD = nf.parse(first).doubleValue();
        double secondD = nf.parse(second).doubleValue();
        return firstD == secondD;
    }
}
