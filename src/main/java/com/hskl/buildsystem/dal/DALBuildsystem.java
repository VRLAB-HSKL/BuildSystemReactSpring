package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;

import java.util.List;

/**
 * Data Access Layer Buildsystem
 * actually not needed
 */
public interface DALBuildsystem {

    // search unity project by name
    UnityProject searchByName(String projectName);

    // returned a list of all scenes from specific unity project
    List<Scene> getAllScenesFromProject(String projectName);

    // create unity project
    void createUnityProject(UnityProject unityProject);

    // delete specific unity project
    void deleteUnityProject(UnityProject unityProject);

    // get all unity projects
    List<UnityProject> getAllProjects();
}
