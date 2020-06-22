package com.hskl.buildsystem.service;


import com.hskl.buildsystem.data.buildsystem.unity.data.UnityData;
import com.hskl.buildsystem.unity.UnityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides the rest of the interfaces for communication with unity
 */
@RestController
public class UnityService {

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityService.class);

    @Autowired
    UnityBuilder unityBuilder;

    /**
     * receive unity project information to store
     * @param data : unity project data as json
     */
    @PostMapping("/api/unity/data")
    public void createProjectData(@RequestBody UnityData data) {
      log.info("Request from Unity: {}", data);
    }

    @GetMapping("/api/unity/createunityproject")
    public void createUnityProject() {
        unityBuilder.createUnityProject();
    }
}
