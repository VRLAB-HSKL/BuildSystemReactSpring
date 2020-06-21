package com.hskl.buildsystem.data.buildsystem.unity.data;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 */
public class UnityData {

    //
    private String projectName;

    //
    private String description;

    //
    private String gitUrl;

    //
    private String unityVersion;

    //
    private String buildTargetWindows;

    //
    private String buildTargetAndroid;

    //
    private boolean inProgress;

    //
    private boolean stable;

    /**
     *
     */
    public UnityData() {

    }

    /**
     *
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
     *
     * @return
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getGitUrl() {
        return gitUrl;
    }

    /**
     *
     * @param gitUrl
     */
    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    /**
     *
     * @return
     */
    public String getUnityVersion() {
        return unityVersion;
    }

    /**
     *
     * @param unityVersion
     */
    public void setUnityVersion(String unityVersion) {
        this.unityVersion = unityVersion;
    }

    /**
     *
     * @return
     */
    public String getBuildTargetWindows() {
        return buildTargetWindows;
    }

    /**
     *
     * @param buildTargetWindows
     */
    public void setBuildTargetWindows(String buildTargetWindows) {
        this.buildTargetWindows = buildTargetWindows;
    }

    /**
     *
     * @return
     */
    public String getBuildTargetAndroid() {
        return buildTargetAndroid;
    }

    /**
     *
     * @param buildTargetAndroid
     */
    public void setBuildTargetAndroid(String buildTargetAndroid) {
        this.buildTargetAndroid = buildTargetAndroid;
    }

    /**
     *
     * @return
     */
    public boolean isInProgress() {
        return inProgress;
    }

    /**
     *
     * @param inProgress
     */
    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    /**
     *
     * @return
     */
    public boolean isStable() {
        return stable;
    }

    /**
     *
     * @param stable
     */
    public void setStable(boolean stable) {
        this.stable = stable;
    }

    /**
     *
     * @return
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
