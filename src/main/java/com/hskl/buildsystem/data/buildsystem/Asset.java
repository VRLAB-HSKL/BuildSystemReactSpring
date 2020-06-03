package com.hskl.buildsystem.data.buildsystem;

public class Asset {

    private String assetName;

    public Asset() {

    }

    public Asset(String name) {
        this.assetName = name;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
