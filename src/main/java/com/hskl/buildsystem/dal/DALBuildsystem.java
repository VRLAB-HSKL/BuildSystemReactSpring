package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;

import java.util.List;

public interface DALBuildsystem {
    UnityProject searchByName(String projectName);
    List<Scene> getAllScenesFromProject(String projectName);
    void createUnityProject(UnityProject unityProject);
    void deleteUnityProject(UnityProject unityProject);
    List<UnityProject> getAllProjects();
}
