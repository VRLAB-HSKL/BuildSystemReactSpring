package com.hskl.buildsystem.service;

import com.hskl.buildsystem.dal.UnityPlatformConfigurationDataImpl;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityProjectNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * This class provides the REST interfaces of the unity platform configurations
 */
@RestController
public class UnityPlatformConfigurationService {

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityPlatformConfigurationService.class);

    //Data access layer for unity platform configurations
    @Autowired
    private UnityPlatformConfigurationDataImpl unityPlatformConfigurationData;

    /**
     * receive unity platform configuration information to store
     * @param data : UnityPlatformConfiguration data as json
     */
    @PostMapping("/api/unity/platformconfigurationservice")
    public void createPlatformConfigurationData(@RequestBody UnityPlatformConfigurationData data) {
        log.info("Request from Unity: {}", data);
        log.info(data.getBuildTarget());
        log.info(data.getBuildTargetGroup());

        unityPlatformConfigurationData.addUnityConfigurationData(data);
    }

    /**
     * this method provides all platform configurations
     * @return List with all stored platform configurations
     */
    @GetMapping("/api/unity/getallplatformconfigurationservice")
    public List<UnityPlatformConfigurationData> getAllPlatformConfigurationData() {
        return unityPlatformConfigurationData.getAllConfigurationDatas();
    }

    /**
     * this method provides a specific platform configuration based on an id
     * @param id mongodb id
     * @return unity platform configuration
     */
    @GetMapping("/api/unity/getplatformconfigurationbyid")
    public UnityPlatformConfigurationData getOneConfig(@RequestParam(name="id") Long id) {
        return unityPlatformConfigurationData.getUnityConfigurationDataById(id);
    }

    /**
     * this method provides a project overview based on the available platform configurations
     */
    @GetMapping("/api/unity/getplatformconfigurationprojectnames")
    public List<UnityProjectNames> getConfigurationProjects() {
        return unityPlatformConfigurationData.getAllUnityProjectNames();
    }

    /**
     * this method delivers all platform configurations for a selected project
     * @param projectName project name
     * @return List with all platform configurations to the selected project
     */
    @GetMapping("/api/unity/getplatformconfigurationbyprojectname")
    public List<UnityPlatformConfigurationData> getConfigurationsByProjectName(@RequestParam(name="projectName") String projectName) {
        return unityPlatformConfigurationData.getUnityConfigurationDataByProjectName(projectName);
    }
}
