package com.hskl.buildsystem.data.buildsystem;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * MongoDB UnityProject Schema
 */
@Document(collection = "UnityProject")
public class UnityProject {

    //counter sequence name for this collection
    @Transient
    public static final String SEQUENCE_NAME = "unity_sequence";

    // project id
    @Id
    private long ID;

    // unity project name
    private String unityProjectName;

    // List with unity scenes
    List<Scene> unityScenes;

    /**
     * ctor
     */
    public UnityProject() {
        this.unityScenes = new ArrayList<Scene>();
    }

    /**
     * ctor with params
     * @param unityProjectName
     * @param unityScenes
     */
    public UnityProject(String unityProjectName, List<Scene> unityScenes) {
        this.unityProjectName = unityProjectName;
        this.unityScenes = unityScenes;
    }

    //getter id
    public long getID() {
        return ID;
    }

    //setter id
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * Unityproject name
     * @return unityproject name
     */
    public String getUnityProjectName() {
        return unityProjectName;
    }

    /**
     * setter unityproject name
     * @param unityProjectName - the project name
     */
    public void setUnityProjectName(String unityProjectName) {
        this.unityProjectName = unityProjectName;
    }

    /**
     * add unity scene
     * @param scene - unity scene
     */
    public void addUnityScene(Scene scene) {
        unityScenes.add(scene);
    }

    /**
     * returned all scenes in project
     * @return all scenes
     */
    public List<Scene> getUnityScenes() {
        return unityScenes;
    }

    /**
     * set unity scenes
     * @param unityScenes - list of scenes
     */
    public void setUnityScenes(List<Scene> unityScenes) {
        this.unityScenes = unityScenes;
    }

}
