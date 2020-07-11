package com.hskl.buildsystem.data.buildsystem.unity.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/***
 * This Class is a Data-Template for the received platform configuration from Unity
 * and also provide the data-schema for the MongoDB
 */
@Document(collection = "UnityPlatformConfigurationData")
public class UnityPlatformConfigurationData {

    @Transient
    public static final String SEQUENCE_NAME = "unityPlatformConfig_sequence";

    @Id
    private long id;

    // configuarion name
    private String configurationName;

    // scene name
    private String sceneName;

    // project name
    private String projectName;

    // description
    private String description;

    // assign viu (Vive Input Utility)
    private boolean viu;

    // assign gvr (Google VR)
    private boolean gvr;

    // assign wavevr (WaveSDK)
    private boolean wavevr;

    // assign middlevr (Middele VR)
    private boolean middlevr;

    // buildplatform like Android / Windows
    private String buildTargetGroup;

    //buildtarget like Android, Win-x64-x32
    private String buildTarget;

    //unity scene index
    private int index;
    /***
     * default ctor
     */
    public UnityPlatformConfigurationData() {

    }

    /***
     * ctor with params
     * @param configurationName
     * @param sceneName
     * @param projectName
     * @param description
     * @param viu
     * @param gvr
     * @param wavevr
     * @param middlevr
     * @param buildTargetGroup
     * @param buildTarget
     * @param index
     */
    public UnityPlatformConfigurationData(String configurationName, String sceneName, String projectName,
                                          String description, boolean viu, boolean gvr, boolean wavevr,
                                          boolean middlevr, String buildTargetGroup, String buildTarget, int index) {
        this.configurationName = configurationName;
        this.sceneName = sceneName;
        this.projectName = projectName;
        this.description = description;
        this.viu = viu;
        this.gvr = gvr;
        this.wavevr = wavevr;
        this.middlevr = middlevr;
        this.buildTargetGroup = buildTargetGroup;
        this.buildTarget = buildTarget;
        this.index = index;
    }

    /***
     *  ctor with params and id
     * @param id
     * @param configurationName
     * @param sceneName
     * @param projectName
     * @param description
     * @param viu
     * @param gvr
     * @param wavevr
     * @param middlevr
     * @param buildTargetGroup
     * @param buildTarget
     * @param index
     */
    public UnityPlatformConfigurationData(long id, String configurationName, String sceneName, String projectName,
                                          String description, boolean viu, boolean gvr, boolean wavevr, boolean middlevr,
                                          String buildTargetGroup, String buildTarget, int index) {
        this.id = id;
        this.configurationName = configurationName;
        this.sceneName = sceneName;
        this.projectName = projectName;
        this.description = description;
        this.viu = viu;
        this.gvr = gvr;
        this.wavevr = wavevr;
        this.middlevr = middlevr;
        this.buildTargetGroup = buildTargetGroup;
        this.buildTarget = buildTarget;
        this.index = index;
    }

    /***
     * get id
     * @return id
     */
    public long getId() {
        return id;
    }

    /***
     * set id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /***
     * get configuration name
     * @return configuration name
     */
    public String getConfigurationName() {
        return configurationName;
    }

    /***
     * set configuration name
     * @param configurationName
     */
    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    /***
     * get scene name
     * @return sceneName
     */
    public String getSceneName() {
        return sceneName;
    }

    /***
     * set scene Name
     * @param sceneName
     */
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    /***
     * get project name
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /***
     * set project Name
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /***
     * get description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /***
     * set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * get Vive Input Utility
     * @return viu
     */
    public boolean isViu() {
        return viu;
    }

    /***
     * set Vive Input Utility
     * @param viu
     */
    public void setViu(boolean viu) {
        this.viu = viu;
    }

    /***
     * set Google VR
     * @return gvr
     */
    public boolean isGvr() {
        return gvr;
    }

    /***
     * set Google VR
     * @param gvr
     */
    public void setGvr(boolean gvr) {
        this.gvr = gvr;
    }

    /***
     * get WaveSDK
     * @return wavevr
     */
    public boolean isWavevr() {
        return wavevr;
    }

    /***
     * set WaveSDK
     * @param wavevr
     */
    public void setWavevr(boolean wavevr) {
        this.wavevr = wavevr;
    }

    /***
     * get MiddleVR
     * @return middlevr
     */
    public boolean isMiddlevr() {
        return middlevr;
    }

    /***
     * set MiddleVR
     * @param middlevr
     */
    public void setMiddlevr(boolean middlevr) {
        this.middlevr = middlevr;
    }

    /***
     * get BuildtargetGroup (Platform)
     * @return buildTargetGroup
     */
    public String getBuildTargetGroup() {
        return buildTargetGroup;
    }

    /***
     * set BuildtargetGroup (Platform)
     * @param buildTargetGroup
     */
    public void setBuildTargetGroup(String buildTargetGroup) {
        this.buildTargetGroup = buildTargetGroup;
    }

    /***
     * get buildTarget (Win-x64-x32, Android)
     * @return buildtarget
     */
    public String getBuildTarget() {
        return buildTarget;
    }

    /***
     * set BuildTarget (Win-x64-x32, Android)
     * @param buildTarget
     */
    public void setBuildTarget(String buildTarget) {
        this.buildTarget = buildTarget;
    }

    /***
     * get scene index
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /***
     * set scene index
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /***
     * toString Method
     * @return class to string
     */
    @Override
    public String toString() {
        return "UnityPlatformConfigurationData{" +
                "id=" + id +
                ", configurationName='" + configurationName + '\'' +
                ", sceneName='" + sceneName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", viu=" + viu +
                ", gvr=" + gvr +
                ", wavevr=" + wavevr +
                ", middlevr=" + middlevr +
                ", buildTargetGroup='" + buildTargetGroup + '\'' +
                ", buildTarget='" + buildTarget + '\'' +
                ", index=" + index +
                '}';
    }
}
