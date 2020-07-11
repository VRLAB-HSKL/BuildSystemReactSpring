package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;

import java.util.List;

public interface DALUnityPlatformConfigurationData {

    /**
     * Add a unity platform configuration to MongoDB
     * @param data
     */
    void addUnityConfigurationData(UnityPlatformConfigurationData data);

    /**
     * returns a List which contains all configurations
     * @return
     */
    List<UnityPlatformConfigurationData> getAllConfigurationDatas();
}
