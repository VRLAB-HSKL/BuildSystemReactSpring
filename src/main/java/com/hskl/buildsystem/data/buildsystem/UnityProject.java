package com.hskl.buildsystem.data.buildsystem;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "UnityProject")
public class UnityProject {

    @Transient
    public static final String SEQUENCE_NAME = "unity_sequence";

    @Id
    private long ID;

    private String unityProjectName;

    List<Scene> unityScenes;

    public UnityProject() {
        this.unityScenes = new ArrayList<Scene>();
    }

    public UnityProject(String unityProjectName, List<Scene> unityScenes) {
        this.unityProjectName = unityProjectName;
        this.unityScenes = unityScenes;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUnityProjectName() {
        return unityProjectName;
    }

    public void setUnityProjectName(String unityProjectName) {
        this.unityProjectName = unityProjectName;
    }

    public void addUnityScene(Scene scene) {
        unityScenes.add(scene);
    }

    public List<Scene> getUnityScenes() {
        return unityScenes;
    }

    public void setUnityScenes(List<Scene> unityScenes) {
        this.unityScenes = unityScenes;
    }

}
