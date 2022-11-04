package com.osokin.exceptions;

public class RegionNameException extends Exception{
    @Override
    public String getMessage() {
        return "Некорректное имя региона";
    }

    public RegionNameException(String regionName) {
        System.out.println(regionName);
    }
}
