package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.ui.data.ProjectData;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDataImpl implements DALProjectData {

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SequenceGeneratorService seqService;

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
        projectData.setiD(seqService.generateSequence(ProjectData.SEQUENCE_NAME));
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
        ProjectData toDelete = mongoTemplate.findById(iD, ProjectData.class);
        assert toDelete != null;
        mongoTemplate.remove(toDelete);
        seqService.decreesSequence(ProjectData.SEQUENCE_NAME);
    }
}
