package com.hskl.buildsystem.service;


import com.hskl.buildsystem.data.buildsystem.unity.data.UnityData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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

    /**
     * receive unity project information to store
     * @param data : unity project data as json
     */
    @PostMapping("/api/unity/data")
    public void createProjectData(@RequestBody UnityData data) {
      log.info("Request from Unity: {}", data);
    }
}
