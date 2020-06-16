package com.hskl.buildsystem.data.buildsystem.ui.data;

/**
 * this class describes the platforms used within the project
 */
public class Platform {

    //platform name
    private String platformName;

    /**
     * ctor
     */
    public Platform() {

    }

    /**
     * ctor with params
     * @param platformname
     */
    public Platform(String platformname) {
        this.platformName = platformname;
    }

    /**
     * getter platform name
     * @return platfromName
     */
    public String getPlatformName() {
        return platformName;
    }

    /**
     * setter platform name
     * @param platformName
     */
    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**
     * toString-Method
     * @return class to String
     */
    @Override
    public String toString() {
        return "Platform{" +
                "platformName='" + platformName + '\'' +
                '}';
    }
}
