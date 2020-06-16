package com.hskl.buildsystem.service;

import com.hskl.buildsystem.data.buildsystem.ui.data.Platform;
import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import com.hskl.buildsystem.data.buildsystem.ui.data.Status;
import com.hskl.buildsystem.data.person.Person;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UIDataService {

    private List<ProjectData> projectDataList;

    @Autowired
    SequenceGeneratorService seqService;

    @GetMapping("/api/data/createdata")
    public void createdata() {
        initTestData();
    }

    @GetMapping("/api/data/getallprojectdata")
    public List<ProjectData> getProjectData() {
        return  projectDataList;
    }

    public void initTestData () {

        projectDataList = new ArrayList<ProjectData>();

        ProjectData a = new ProjectData();
        a.setiD(seqService.generateSequence(a.SEQUENCE_NAME));
        a.setName("Miniworlds");
        a.setDescription("Miniworlds description");
        a.setGitUrl("www.setgiturl.de");
        Status astatus = new Status();
        astatus.setInProgress(true);
        a.setStatus(astatus);
        List<Platform> aList = new ArrayList<>();
        Platform win = new Platform("win-standalone");
        Platform android = new Platform("android");
        aList.add(win);
        aList.add(android);
        a.setPlatformList(aList);
        a.setUnityVersion("Unity 2019.04 LTS");
        projectDataList.add(a);
    }

}
