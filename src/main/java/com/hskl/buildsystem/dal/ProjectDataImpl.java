package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDataImpl implements DALProjectData {

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * find all project data in MongoDB
     *
     * @return List of ProjectData
     */
    @Override
    public List<ProjectData> findAll() {
        return mongoTemplate.findAll(ProjectData.class);
    }

    /**
     * find projectData by ID
     *
     * @param iD projectData iD
     * @return ProjectData
     */
    @Override
    public ProjectData findById(Long iD) {
        return mongoTemplate.findById(iD, ProjectData.class);
    }

    /**
     * stored new projectData in MongoDB
     *
     * @param projectData
     */
    @Override
    public void createProjectData(ProjectData projectData) {
        mongoTemplate.save(projectData);
    }

    /**
     * update existing projectData
     *
     * @param projectData
     */
    @Override
    public void updateProjectData(ProjectData projectData) {
        /* TODO */
    }

    /**
     * delete projectData from MongoDB
     *
     * @param iD projectData Id
     */
    @Override
    public void deleteProjectData(Long iD) {
        mongoTemplate.remove(new Query(Criteria.where("iD").is(iD)));
    }
}
