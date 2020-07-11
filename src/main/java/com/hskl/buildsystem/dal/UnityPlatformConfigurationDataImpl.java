package com.hskl.buildsystem.dal;


import com.hskl.buildsystem.data.buildsystem.unity.data.UnityPlatformConfigurationData;
import com.hskl.buildsystem.data.seq.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnityPlatformConfigurationDataImpl implements DALUnityPlatformConfigurationData{

    //MongoDB Template
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    SequenceGeneratorService seqService;

    /**
     * Add a unity platform configuration to MongoDB
     *
     * @param data
     */
    @Override
    public void addUnityConfigurationData(UnityPlatformConfigurationData data) {
        data.setId(seqService.generateSequence(UnityPlatformConfigurationData.SEQUENCE_NAME));
        mongoTemplate.save(data);
    }

    /**
     * returns a List which contains all configurations
     *
     * @return List<UnityPlatformConfigurationData>
     */
    @Override
    public List<UnityPlatformConfigurationData> getAllConfigurationDatas() {
        return mongoTemplate.findAll(UnityPlatformConfigurationData.class);
    }
}
