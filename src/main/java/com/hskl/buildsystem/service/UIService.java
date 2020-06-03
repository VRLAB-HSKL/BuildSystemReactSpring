package com.hskl.buildsystem.service;

import com.hskl.buildsystem.data.BuildsystemImpl;
import com.hskl.buildsystem.data.buildsystem.Asset;
import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides the REST-Server for Buildsystem-UI to Buildsystem-Core
 * communication
 */
@RestController
public class UIService {

    @Autowired
    BuildsystemImpl buildsystemDAL;


    /**
     * Test Case for REST-Service simulation
     * @return UnityProject
     */
    private UnityProject initUnityProject(){
        Asset asset = new Asset("VIU");
        Asset asset1 = new Asset("GVR");
        Scene scene = new Scene();
        scene.setSceneName("Test_Scene");
        scene.addAsset(asset);
        scene.addAsset(asset1);
        UnityProject unityProject = new UnityProject();
        unityProject.addUnityScene(scene);
        unityProject.setUnityProjectName("Test_Unity_Project");
        return  unityProject;
    }

    /**
     * creates a UnityProject in Database
     */
    @GetMapping("/createunityproject")
    public void createUnityProject() {
        buildsystemDAL.createUnityProject(initUnityProject());
    }

    /**
     * returns all stored unityprojects from database
     * @return UnityProject
     */
    @RequestMapping("/findunityproject")
    public UnityProject findUnityProject(){
        UnityProject unityProject = buildsystemDAL.searchByName("Test_Unity_Project");
        return unityProject;
    }

    /**
     * delete a specific UnityProject
     */
    @RequestMapping("/deleteunityproject")
    public void removeUnityProject() {
        UnityProject unityProject = buildsystemDAL.searchByName("Test_Unity_Project");
        buildsystemDAL.deleteUnityProject(unityProject);
    }
}
