package com.osokin.region;

import com.osokin.exceptions.RegionNameException;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class RegionCity {


    public String regionName;
    public boolean isCity;
    private static final List<String> regionsWithCities = new ArrayList<>();

    static {
        regionsWithCities.add(RegionNames.pskovOblast);
        regionsWithCities.add(RegionNames.kurganOblast);
        regionsWithCities.add(RegionNames.lipetskOblast);
        regionsWithCities.add(RegionNames.orelOblast);
        regionsWithCities.add(RegionNames.tverOblast);

    }

    public RegionCity(String regionName, boolean isCity) throws RegionNameException {
        if (!Region.regionNameList.contains(regionName)) throw new RegionNameException(regionName);
        this.regionName = regionName;
        this.isCity = isCity;
    }

    public RegionCity(String regionName, String cityAddress) throws RegionNameException {
        if (!Region.regionNameList.contains(regionName)) throw new RegionNameException(regionName);
        this.regionName = regionName;
        this.isCity = isCity(regionName, cityAddress);
    }

    private boolean isCity(String regionName, String cityAddress) {
        if (!regionsWithCities.contains(regionName)) return false;
        String city = switchRegionAndReturnCity(regionName);
        return cityAddress.contains(city);
    }

    private static String switchRegionAndReturnCity(String regionName) {
        switch (regionName) {
            case RegionNames.pskovOblast: return RegionNames.pskov;
            case RegionNames.kurganOblast: return RegionNames.kurgan;
            case RegionNames.lipetskOblast: return RegionNames.lipetsk;
            case RegionNames.orelOblast: return RegionNames.orel;
            case RegionNames.tverOblast: return RegionNames.tver;
            default: return "";
        }
    }

}
