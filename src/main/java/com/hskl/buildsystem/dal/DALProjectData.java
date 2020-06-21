package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;

import java.util.List;

public interface DALProjectData {

    /**
     * find all project data in MongoDB
     * @return List of ProjectData
     */
    public List<ProjectData> findAll();

    /**
     * find projectData by ID
     * @param iD projectData iD
     * @return ProjectData
     */
    public ProjectData findById(Long iD);

    /**
     * stored new projectData in MongoDB
     * @param projectData
     */
    public void createProjectData(ProjectData projectData);

    /**
     * update existing projectData
     * @param projectData
     */
    public void updateProjectData(ProjectData projectData);

    /**
     * delete projectData from MongoDB
     * @param iD projectData Id
     */
    public void deleteProjectData(Long iD);
}
