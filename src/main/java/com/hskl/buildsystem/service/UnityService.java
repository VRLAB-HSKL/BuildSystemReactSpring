package com.hskl.buildsystem.service;


import com.hskl.buildsystem.dal.ProjectDataImpl;
import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityData;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityDataMapper;
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

    //unity project builder
    @Autowired
    UnityBuilder unityBuilder;

    //Unity Data Mapper - mapped received data from unity to the ProjectData class format
    @Autowired
    UnityDataMapper dataMapper;

    //Project Data - Data Access Layer
    @Autowired
    ProjectDataImpl projectDataDAL;

    /**
     * receive unity project information to store
     * @param data : unity project data as json
     */
    @PostMapping("/api/unity/data")
    public void createProjectData(@RequestBody UnityData data) {
      log.info("Request from Unity: {}", data);
      ProjectData projectData = dataMapper.convertDataToProjectData(data);
      projectDataDAL.createProjectData(projectData);

    }

    /**
     * this call triggers the creation of a unity project by using a python script
     * actual the rest interface dont accept params - so a hard coded example will start the unity project creation
     */
    @GetMapping("/api/unity/createunityproject")
    public void createUnityProject() {
        unityBuilder.createUnityProject();
    }
}
