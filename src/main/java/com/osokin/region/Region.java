package com.osokin.region;

import lombok.Getter;
import com.osokin.exceptions.RegionNameException;

import java.util.*;


import static com.osokin.region.RegionNames.*;
@Getter
public class Region {
    public static final List<String> regionNameList = new ArrayList<>();
    private static final Map<RegionCity, Region> regionMap = new HashMap<>();
    public static Map<RegionCity, Region> getRegionMap() {
        return  regionMap;
    }

    static {
        initRegionNameList();
        try {
            initRegionMap();
        } catch (RegionNameException e) {
            throw new RuntimeException(e);
        }
    }


    private String regionName;
    private boolean isCity;
    private int baseRate;
    private int costPerAdditionalKg;

    public Region(String regionName, boolean isCity, int baseRate, int costPerAdditionalKg) {
        this.regionName = regionName;
        this.isCity = isCity;
        this.baseRate = baseRate;
        this.costPerAdditionalKg = costPerAdditionalKg;
    }


    private static void initRegionNameList() {
        regionNameList.add(moscowCity);
        regionNameList.add(moscowOblast);
        regionNameList.add(pskovOblast);
        regionNameList.add(kurganOblast);
        regionNameList.add(lipetskOblast);
        regionNameList.add(orelOblast);
        regionNameList.add(tverOblast);
        regionNameList.add(yaroslavlOblast);
        regionNameList.add(leningradOblast);
        regionNameList.add(kareliaRepublic);
    }

    private static void initRegionMap() throws RegionNameException {
        regionMap.put(new RegionCity(moscowCity, false),
                new Region(moscowCity, false, 148, 18));
        regionMap.put(new RegionCity(moscowOblast, false),
                new Region(moscowOblast, false, 167, 18));
        regionMap.put(new RegionCity(pskovOblast, true),
                new Region(pskovOblast, true, 168, 36));
        regionMap.put(new RegionCity(pskovOblast, false),
                new Region(pskovOblast, false, 239, 36));
        regionMap.put(new RegionCity(kurganOblast, true),
                new Region(kurganOblast, true, 197, 36));
        regionMap.put(new RegionCity(kurganOblast, false),
                new Region(kurganOblast, false, 299, 36));
        regionMap.put(new RegionCity(lipetskOblast, true),
                new Region(lipetskOblast, true, 168, 36));
        regionMap.put(new RegionCity(lipetskOblast, false),
                new Region(lipetskOblast, false, 239, 36));
        regionMap.put(new RegionCity(orelOblast, true),
                new Region(orelOblast, true, 168, 36));
        regionMap.put(new RegionCity(orelOblast, false),
                new Region(orelOblast, false, 239, 36));
        regionMap.put(new RegionCity(tverOblast, true),
                new Region(tverOblast, true, 168, 36));
        regionMap.put(new RegionCity(tverOblast, false),
                new Region(tverOblast, false, 239, 36));
        regionMap.put(new RegionCity(yaroslavlOblast, false),
                new Region(yaroslavlOblast, false, 168, 36));
        regionMap.put(new RegionCity(leningradOblast, false),
                new Region(leningradOblast, false, 239, 36));
        regionMap.put(new RegionCity(kareliaRepublic, false),
                new Region(kareliaRepublic, false, 299, 36));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return isCity == region.isCity && baseRate == region.baseRate && costPerAdditionalKg == region.costPerAdditionalKg && regionName.equals(region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName, isCity, baseRate, costPerAdditionalKg);
    }
}
