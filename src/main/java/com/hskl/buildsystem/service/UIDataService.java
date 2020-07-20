package com.hskl.buildsystem.service;

import com.hskl.buildsystem.dal.ProjectDataImpl;
import com.hskl.buildsystem.data.buildsystem.ui.data.Platform;
import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import com.hskl.buildsystem.data.buildsystem.ui.data.Status;
import com.hskl.buildsystem.data.person.Person;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the REST interfaces which contain Unity project information.
 */
@RestController
public class UIDataService {

    //testing list which contains test data
    private List<ProjectData> projectDataList;

    //the logger
    private final Logger log = LoggerFactory.getLogger(UnityService.class);

    //Data Access Layer for ProjectData
    @Autowired
    ProjectDataImpl projectDataDAL;

    //Sequence Service
    @Autowired
    SequenceGeneratorService seqService;

    /**
     * init Testdata
     */
    @GetMapping("/api/data/testdata")
    public void createtestdata() {
        initTestData();
    }

    /**
     * Provides ProjectData by ID
     * @param iD
     * @return ProjectData
     */
    @GetMapping("/api/data/findById")
    public ProjectData findById(@RequestParam(name="id") Long iD){
        return projectDataDAL.findById(iD);
    }

    /**
     * Find all Project datas stored in mongodb
     * @return List with all stored project Datas
     */
    @GetMapping("/api/data/findAll")
    public List<ProjectData> findAll() {
        return  projectDataDAL.findAll();
    }

    /**
     * Creates / Stored a new ProjectData
     * @param data
     */
    @GetMapping("/api/data/create")
    public void createProjectData(ProjectData data) {
        projectDataDAL.createProjectData(data);
    }

    /**
     * update specific Data
     * @param data
     */
    @GetMapping("/api/data/updateData")
    public void updateProjectData(ProjectData data) {
        projectDataDAL.updateProjectData(data);
    }

    /**
     * Delete unity project Data by id
     * @param iD
     */
    @GetMapping("/api/data/deleteById")
    public void deleteDataById(@RequestParam(name="id") Long iD) {
        log.info("received id: " + iD);
        projectDataDAL.deleteProjectData(iD);
    }

    /**
     *  provides a List witch contains all stored ProjectData's
     *  For testing only. Becaus it returns the List from this class
     * @return List with all ProjectDatas
     */
    @GetMapping("/api/data/getallprojectdata")
    public List<ProjectData> getProjectData() {
        return  projectDataList;
    }

    /**
     * test data for unity projects
     */
    public void initTestData () {

        projectDataList = new ArrayList<ProjectData>();

        ProjectData a = new ProjectData();
        a.setName("Miniworlds");
        a.setDescription("Miniworlds description");
        a.setGitUrl("www.setgiturl.de");
        Status astatus = new Status();
        astatus.setInProgress(true);
        a.setStatus(astatus);
        List<Platform> aList = new ArrayList<>();
        Platform win = new Platform("win-standalone");
        Platform android = new Platform("android");
        aList.add(win);
        aList.add(android);
        a.setPlatformList(aList);
        a.setUnityVersion("Unity 2019.04 LTS");
        projectDataList.add(a);
        projectDataDAL.createProjectData(a);
    }

}
