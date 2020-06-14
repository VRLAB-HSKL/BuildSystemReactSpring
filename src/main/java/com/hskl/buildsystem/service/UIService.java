package com.hskl.buildsystem.service;

import com.hskl.buildsystem.dal.BuildsystemImpl;
import com.hskl.buildsystem.data.buildsystem.Asset;
import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class provides the REST-Server for Buildsystem-UI to Buildsystem-Core
 * communication
 */
@RestController
public class UIService {

    private static final String PROJECT_SEQ_KEY = "unitproject";

    @Autowired
    BuildsystemImpl buildsystemDAL;

    @Autowired
    SequenceGeneratorService seqService;


    /**
     * Test Case for REST-Service simulation
     * @return UnityProject
     */
    private UnityProject initTestOneUnityProject(){
        Asset asset = new Asset("VIU");
        Asset asset1 = new Asset("GVR");
        Scene scene = new Scene();
        scene.setSceneName("Test_Scene_One");
        scene.addAsset(asset);
        scene.addAsset(asset1);
        UnityProject unityProject = new UnityProject();
        unityProject.setID(seqService.generateSequence(unityProject.SEQUENCE_NAME));
        unityProject.addUnityScene(scene);
        unityProject.setUnityProjectName("Test_Unity_Project_One");
        return  unityProject;
    }

    /**
     * Test Case for REST-Service simulation
     * @return UnityProject
     */
    private UnityProject initTestTwoUnityProject(){
        Asset asset = new Asset("VIU");
        Asset asset1 = new Asset("GVR");
        Scene scene = new Scene();
        scene.setSceneName("Test_Scene_Two");
        scene.addAsset(asset);
        scene.addAsset(asset1);
        UnityProject unityProject = new UnityProject();
        unityProject.setID(seqService.generateSequence(unityProject.SEQUENCE_NAME));
        unityProject.addUnityScene(scene);
        unityProject.setUnityProjectName("Test_Unity_Project_Two");
        return  unityProject;
    }

    /**
     * Test Case for REST-Service simulation
     * @return UnityProject
     */
    private UnityProject initTestThreeUnityProject(){
        Asset asset = new Asset("VIU");
        Asset asset1 = new Asset("GVR");
        Scene scene = new Scene();
        scene.setSceneName("Test_Scene_Three");
        scene.addAsset(asset);
        scene.addAsset(asset1);
        UnityProject unityProject = new UnityProject();
        unityProject.setID(seqService.generateSequence(unityProject.SEQUENCE_NAME));
        unityProject.addUnityScene(scene);
        unityProject.setUnityProjectName("Test_Unity_Project_Three");
        return  unityProject;
    }


    /**
     * creates a UnityProject in Database
     */
    @GetMapping("/api/createunityproject")
    public void createUnityProject() {
        buildsystemDAL.createUnityProject(initTestOneUnityProject());
        buildsystemDAL.createUnityProject(initTestTwoUnityProject());
        buildsystemDAL.createUnityProject(initTestThreeUnityProject());
    }

    /**
     * returns all stored unityprojects from database
     * @return UnityProject
     */
    @RequestMapping("/api/findunityproject")
    public UnityProject findUnityProject(){
        UnityProject unityProject = buildsystemDAL.searchByName("Test_Unity_Project");
        return unityProject;
    }

    @RequestMapping("/api/getallunityprojects")
    public List<UnityProject> findAllUnityProjects() {
        return buildsystemDAL.getAllProjects();
    }

    /**
     * delete a specific UnityProject
     */
    @RequestMapping("/api/deleteunityproject")
    public void removeUnityProject() {
        UnityProject unityProject = buildsystemDAL.searchByName("Test_Unity_Project");
        buildsystemDAL.deleteUnityProject(unityProject);
    }
}
