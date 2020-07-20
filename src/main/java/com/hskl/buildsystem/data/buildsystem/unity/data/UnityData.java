package com.hskl.buildsystem.data.buildsystem.unity.data;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The class provides the Unity Project information and is required so that
 * the received JSON data are automatically mapped into the corresponding object
 */
public class UnityData {

    //unity project name
    private String projectName;

    //description
    private String description;

    //github url
    private String gitUrl;

    //unity version
    private String unityVersion;

    //buildtarget windows
    private String buildTargetWindows;

    //buildtarget android
    private String buildTargetAndroid;

    //Git-Status: inProgress
    private boolean inProgress;

    //Git-Status: Stable
    private boolean stable;

    /**
     * ctor
     */
    public UnityData() {

    }

    /**
     * ctor with params
     * @param projectName
     * @param description
     * @param gitUrl
     * @param unityVersion
     * @param buildTargetWindows
     * @param buildTargetAndroid
     * @param inProgress
     * @param stable
     */
    public UnityData(String projectName, String description, String gitUrl, String unityVersion,
                     String buildTargetWindows, String buildTargetAndroid, boolean inProgress, boolean stable) {
        this.projectName = projectName;
        this.description = description;
        this.gitUrl = gitUrl;
        this.unityVersion = unityVersion;
        this.buildTargetWindows = buildTargetWindows;
        this.buildTargetAndroid = buildTargetAndroid;
        this.inProgress = inProgress;
        this.stable = stable;
    }

    /**
     * get project name
     * @return project Name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * set project name
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * get description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get git url
     * @return gitUrl
     */
    public String getGitUrl() {
        return gitUrl;
    }

    /**
     * set github url
     * @param gitUrl
     */
    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    /**
     * get unity version
     * @return
     */
    public String getUnityVersion() {
        return unityVersion;
    }

    /**
     * set unity version
     * @param unityVersion
     */
    public void setUnityVersion(String unityVersion) {
        this.unityVersion = unityVersion;
    }

    /**
     * get buildtarget windows
     * @return buildTargetWindows
     */
    public String getBuildTargetWindows() {
        return buildTargetWindows;
    }

    /**
     * set buildtarget Windows
     * @param buildTargetWindows
     */
    public void setBuildTargetWindows(String buildTargetWindows) {
        this.buildTargetWindows = buildTargetWindows;
    }

    /**
     * get buildtarget Android
     * @return buildTargetAndroid
     */
    public String getBuildTargetAndroid() {
        return buildTargetAndroid;
    }

    /**
     * set buildtarget Android
     * @param buildTargetAndroid
     */
    public void setBuildTargetAndroid(String buildTargetAndroid) {
        this.buildTargetAndroid = buildTargetAndroid;
    }

    /**
     * get git status "inprogress"
     * @return inProgress
     */
    public boolean isInProgress() {
        return inProgress;
    }

    /**
     * set git status "inprogress"
     * @param inProgress
     */
    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    /**
     * get git status stable
     * @return stable
     */
    public boolean isStable() {
        return stable;
    }

    /**
     * set git status stable
     * @param stable
     */
    public void setStable(boolean stable) {
        this.stable = stable;
    }

    /**
     * toString()
     * @return class to string
     */
    @Override
    public String toString() {
        return "UnityData{" +
                "projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", unityVersion='" + unityVersion + '\'' +
                ", buildTargetWindows='" + buildTargetWindows + '\'' +
                ", buildTargetAndroid='" + buildTargetAndroid + '\'' +
                ", inProgress=" + inProgress +
                ", stable=" + stable +
                '}';
    }
}
