package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityProjectNames;

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

    /**
     * return a unity plaform configuration selected by id
     * @param id
     */
    UnityPlatformConfigurationData getUnityConfigurationDataById(long id);

    /**
     * return all project names from all stored platform configurations
     * @return a List<UnityProjectNames> that contains all unity project names
     */
    List<UnityProjectNames> getAllUnityProjectNames();

    /**
     * return all unity platform configurations selected by project name
     * @param projectName
     * @return a List<UnityPlatformConfigurationData> that contains all platform configurations for one project
     */
    List<UnityPlatformConfigurationData> getUnityConfigurationDataByProjectName(String projectName);
}
