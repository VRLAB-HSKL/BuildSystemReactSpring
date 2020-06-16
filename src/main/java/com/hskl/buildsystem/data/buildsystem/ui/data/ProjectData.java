package com.hskl.buildsystem.data.buildsystem.ui.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * This class represents project information such as name,
 * description, status, platforms used, github url and the Unity version used
 */
@Document(collection = "ProjectData")
public class ProjectData {

    @Transient
    public static final String SEQUENCE_NAME = "projectdata_sequence";

    //auto generated id
    @Id
    private long iD;

    //project name
    private String name;

    //project description
    private String description;

    //List of all used platform within the project
    private List<Platform> platformList;

    //Project status like inProgress or stable
    private Status status;

    // GitHub Url
    private String gitUrl;

    // Unity-Version of the project
    private String unityVersion;

    /**
     * ctor
     */
    public ProjectData() {

    }

    /**
     * ctor with params
     * @param Name
     * @param Description
     * @param PlatformList
     * @param status
     * @param GitURL
     * @param UnityVersion
     */
    public ProjectData(
            String Name, String Description, List<Platform> PlatformList,
            Status status, String GitURL, String UnityVersion) {
        this.name = Name;
        this.description = Description;
        this.platformList = PlatformList;
        this.status = status;
        this.gitUrl = GitURL;
        this.unityVersion = UnityVersion;
    }

    /**
     * Getter id
     * @return id
     */
    public long getiD() {
        return iD;
    }

    /**
     * Setter id
     * @param iD
     */
    public void setiD(long iD) {
        this.iD = iD;
    }

    /**
     * get ProjectName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set Project name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * get platform list
     * @return platformList
     */
    public List<Platform> getPlatformList() {
        return platformList;
    }

    /**
     * set platform list
     * @param platformList
     */
    public void setPlatformList(List<Platform> platformList) {
        this.platformList = platformList;
    }

    /**
     * get project status
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * set status
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * get github url
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
     * toString method
     * @return class to string
     */
    @Override
    public String toString() {
        return "ProjectData{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", platformList=" + platformList +
                ", status=" + status +
                ", gitUrl='" + gitUrl + '\'' +
                ", unityVersion='" + unityVersion + '\'' +
                '}';
    }
}
