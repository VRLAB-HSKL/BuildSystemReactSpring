package com.hskl.buildsystem.data.buildsystem.unity.data;

import com.hskl.buildsystem.data.buildsystem.ui.data.Platform;
import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import com.hskl.buildsystem.data.buildsystem.ui.data.Status;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnityDataMapper {

    @Autowired
    SequenceGeneratorService seqService;

    /**
     * Convert received unity data to ProjectData
     * @param unityData received unity project informations
     */
    public ProjectData convertDataToProjectData(UnityData unityData) {
        ProjectData projectData = new ProjectData();
        projectData.setiD(seqService.generateSequence(ProjectData.SEQUENCE_NAME));
        projectData.setName(unityData.getProjectName());
        projectData.setDescription(unityData.getDescription());
        Platform android = new Platform();
        android.setPlatformName(unityData.getBuildTargetAndroid());
        Platform windows = new Platform();
        windows.setPlatformName(unityData.getBuildTargetWindows());
        List<Platform> platformList = new ArrayList<Platform>();
        platformList.add(android);
        platformList.add(windows);
        projectData.setPlatformList(platformList);
        Status status = new Status();
        status.setInProgress(unityData.isInProgress());
        status.setStable(unityData.isStable());
        projectData.setStatus(status);
        projectData.setGitUrl(unityData.getGitUrl());
        projectData.setUnityVersion(unityData.getUnityVersion());
        return projectData;
    }
}
