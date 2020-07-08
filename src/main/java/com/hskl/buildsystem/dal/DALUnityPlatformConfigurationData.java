package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;

public interface DALUnityPlatformConfigurationData {

    /**
     * Add a unity platform configuration to MongoDB
     * @param data
     */
    void addUnityConfigurationData(UnityPlatformConfigurationData data);
}
