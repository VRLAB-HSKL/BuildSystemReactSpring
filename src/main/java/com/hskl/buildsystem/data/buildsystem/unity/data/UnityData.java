package com.hskl.buildsystem.data.buildsystem.unity.data;

public class UnityData {

    private String projectName;

    private String description;

    private String gitUrl;

    private String unityVersion;

    private String buildTargetWindows;

    private String buildTargetAndroid;

    private boolean inProgress;

    private boolean stable;

    public UnityData() {

    }

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getUnityVersion() {
        return unityVersion;
    }

    public void setUnityVersion(String unityVersion) {
        this.unityVersion = unityVersion;
    }

    public String getBuildTargetWindows() {
        return buildTargetWindows;
    }

    public void setBuildTargetWindows(String buildTargetWindows) {
        this.buildTargetWindows = buildTargetWindows;
    }

    public String getBuildTargetAndroid() {
        return buildTargetAndroid;
    }

    public void setBuildTargetAndroid(String buildTargetAndroid) {
        this.buildTargetAndroid = buildTargetAndroid;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

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
