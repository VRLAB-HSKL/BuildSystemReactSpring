package com.hskl.buildsystem.dal;


import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;
import com.hskl.buildsystem.data.buildsystem.unity.data.UnityProjectNames;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The class manages the different requests between the application and MongoDB.
 * provides the data access layer to save and load platform configurations
 */
@Repository
public class UnityPlatformConfigurationDataImpl implements DALUnityPlatformConfigurationData{

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    //sequence service
    @Autowired
    SequenceGeneratorService seqService;

    //contains all project names of the configurations in the mongodb
    private final List<UnityProjectNames> unityProjectNamesList = new ArrayList<UnityProjectNames>();

    /**
     * Add a unity platform configuration to MongoDB
     *
     * @param data - platform configuration
     */
    @Override
    public void addUnityConfigurationData(UnityPlatformConfigurationData data) {
        data.setId(seqService.generateSequence(UnityPlatformConfigurationData.SEQUENCE_NAME));
        mongoTemplate.save(data);
    }

    /**
     * returns a List which contains all saved platform configurations
     *
     * @return List<UnityPlatformConfigurationData>
     */
    @Override
    public List<UnityPlatformConfigurationData> getAllConfigurationDatas() {
        return mongoTemplate.findAll(UnityPlatformConfigurationData.class);
    }

    /**
     * return a unity plaform configuration selected by id
     *
     * @param id
     */
    @Override
    public UnityPlatformConfigurationData getUnityConfigurationDataById(long id) {
        return mongoTemplate.findById(id, UnityPlatformConfigurationData.class);
    }

    /**
     * return all project names from all stored platform configurations
     *
     * @return a List<UnityProjectNames> that contains all unity project names
     */
    @Override
    public List<UnityProjectNames> getAllUnityProjectNames() {
        List<UnityPlatformConfigurationData> listConfig = new ArrayList<UnityPlatformConfigurationData>();
        listConfig = mongoTemplate.findAll(UnityPlatformConfigurationData.class);
        int index = 0;
        for(UnityPlatformConfigurationData data : listConfig) {
            UnityProjectNames unityProjectNames = new UnityProjectNames();
            unityProjectNames.setIndex(index++);
            unityProjectNames.setProjectName(data.getProjectName());
           updateProjectNamesList(unityProjectNames);
        }
        return unityProjectNamesList;
    }

    /**
     * return all unity platform configurations selected by project name
     *
     * @param projectName
     * @return a List<UnityPlatformConfigurationData> that contains all platform configurations for one project
     */
    @Override
    public List<UnityPlatformConfigurationData> getUnityConfigurationDataByProjectName(String projectName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("projectName").is(projectName));
        return mongoTemplate.find(query, UnityPlatformConfigurationData.class);
    }

    /**
     * This method uses the transferred parameters to check whether this project already exists.
     * If not, it will be added to the list
     * @param unityProjectNames - unity project name
     */
    private void updateProjectNamesList(UnityProjectNames unityProjectNames) {

        boolean exists = false;

        for(UnityProjectNames unames : unityProjectNamesList) {
            if(unames.getProjectName().equals(unityProjectNames.getProjectName())) {
                exists = true;
            }
        }

        if(!exists) unityProjectNamesList.add(unityProjectNames);
    }
}
