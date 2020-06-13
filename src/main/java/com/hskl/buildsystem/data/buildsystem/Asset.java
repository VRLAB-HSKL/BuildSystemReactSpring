package com.hskl.buildsystem.data.buildsystem;

/**
 * MongoDB Asset schema
 */
public class Asset {

    //asset name
    private String assetName;

    /**
     * ctor
     */
    public Asset() {

    }

    /**
     * ctor with params
     * @param name - asset name
     */
    public Asset(String name) {
        this.assetName = name;
    }

    /**
     * getter asset name
     * @return assetName
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * setter asset name
     * @param assetName - asset name
     */
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
