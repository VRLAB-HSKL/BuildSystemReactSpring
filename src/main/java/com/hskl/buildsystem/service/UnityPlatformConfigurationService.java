package com.hskl.buildsystem.service;

import com.hskl.buildsystem.dal.UnityPlatformConfigurationDataImpl;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 */
@RestController
public class UnityPlatformConfigurationService {

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityPlatformConfigurationService.class);

    @Autowired
    private UnityPlatformConfigurationDataImpl unityPlatformConfigurationData;

    /**
     * receive unity platform configuration information to store
     * @param data : UnityPlatformConfiguration data as json
     */
    @PostMapping("/api/unity/platformconfigurationservice")
    public void createPlatformConfigurationData(@RequestBody UnityPlatformConfigurationData data) {
        log.info("Request from Unity: {}", data);
        unityPlatformConfigurationData.addUnityConfigurationData(data);
    }
}
