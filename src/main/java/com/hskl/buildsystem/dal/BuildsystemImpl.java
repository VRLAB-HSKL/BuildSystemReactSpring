package com.hskl.buildsystem.dal;

import com.hskl.buildsystem.data.buildsystem.Scene;
import com.hskl.buildsystem.data.buildsystem.UnityProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class BuildsystemImpl implements DALBuildsystem {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UnityProject searchByName(String unityProjectName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("unityProjectName").is(unityProjectName));
        return mongoTemplate.findOne(query, UnityProject.class);
    }

    @Override
    public List<Scene> getAllScenesFromProject(String projectName) {
        return null;
    }


    @Override
    public void createUnityProject(UnityProject unityProject) {
        mongoTemplate.save(unityProject);

    }

    @Override
    public void deleteUnityProject(UnityProject unityProject) {
        mongoTemplate.remove(unityProject);
    }

    @Override
    public List<UnityProject> getAllProjects() {
        return mongoTemplate.findAll(UnityProject.class);
    }

}
