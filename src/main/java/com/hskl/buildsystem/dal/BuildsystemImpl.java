package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Implementation of the data access layer
 */
@Repository
public class BuildsystemImpl implements DALBuildsystem {

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * search unity project by name
     * @param unityProjectName - unity project name
     * @return UnityProject
     */
    @Override
    public UnityProject searchByName(String unityProjectName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("unityProjectName").is(unityProjectName));
        return mongoTemplate.findOne(query, UnityProject.class);
    }

    /**
     * returned a list of all scenes from specific unity project
     * @param projectName - unity project name
     * @return List of all scene from a specific unity project
     */
    @Override
    public List<Scene> getAllScenesFromProject(String projectName) {
        return null;
    }


    /**
     * create unity project which is stored in mongodb
     * @param unityProject - configured UnityProject
     */
    @Override
    public void createUnityProject(UnityProject unityProject) {
        mongoTemplate.save(unityProject);
    }

    /**
     * delete specific unity project
     * @param unityProject
     */
    @Override
    public void deleteUnityProject(UnityProject unityProject) {
        mongoTemplate.remove(unityProject);
    }

    /**
     * get all stored UnityProjects in MongoDB
     * @return List of all UnityProject's
     */
    @Override
    public List<UnityProject> getAllProjects() {
        return mongoTemplate.findAll(UnityProject.class);
    }

}
